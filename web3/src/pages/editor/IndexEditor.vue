<template>
  <el-container>
    <el-header>
      <nav-bar></nav-bar>
    </el-header>
    <el-main>
      <el-tabs
          v-model="activeName"
          type="card"
          class="demo-tabs"
          @tab-click="handleClick"
      >
        <el-tab-pane label="查看文章" name="first" class="tabFirstPane">
          <article-show
              v-for="item in showDataArticle"
              v-bind:key="item.id"
              :title="item.title"
              :author="item.author"
              :text="item.article"
              :href="url + item.uuid"
              :date="item.time"
              :star="item.articleStar"
              :watch="item.articleWatch"
              :img-href="item.imgHref"
          >
          </article-show>
        </el-tab-pane>
        <el-tab-pane label="新建文章" name="second">
          <v-md-editor
              v-model="text"
              :disabled-menus="[]"
              height="800px"
              @upload-image="handleUploadImage"
              left-toolbar="undo redo clear | h bold italic strikethrough quote | ul ol table hr | link image code | save | tip | emoji"
              @save="saveText"
          >

          </v-md-editor>
        </el-tab-pane>
      </el-tabs>

    </el-main>
    <el-dialog v-model="dialogFormVisible" title="新建文章">
      <el-form :model="form">
        <el-form-item label="文章标题" :label-width="formLabelWidth">
          <el-input v-model="form.title" autocomplete="off" />
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="dialogFormVisible = false"
        >Confirm</el-button
        >
      </span>
      </template>
    </el-dialog>
  </el-container>
</template>

<script>
import {ref, reactive} from "vue";
import {uploadImages,saveArticle,selectArticle, selectStar} from "@/axios/request";
import {onMounted} from "vue";
import articleShow from "@/components/ArticleShow";
import NavBar from "@/components/NavBar";
import {regularMatch} from "@/common/js/global";

export default {
  components:{articleShow,NavBar},
  setup(){
    const text = ref("");
    const data = ref();
    const activeName = ref("first");
    const dialogFormVisible = ref(false);
    const formLabelWidth = ref("120px")
    const form = reactive({
      title:""
    })

    const articleCount = ref(0);
    const articleViewCount = ref(0);
    const showDataArticle = ref({});
    const dataStar = ref();

    //测试数据
    const zero = ref(0);
    const url = ref("/editorArticle/")

    const update = async () => {
      showDataArticle.value = (await selectArticle().then()).data.data;
      dataStar.value = (await selectStar().then()).data.data;
      articleCount.value = showDataArticle.value.length;
      let watchs = 0;
      for (let i = 0; i < dataStar.value.length; i++) {
        watchs += dataStar.value[i].articleWatch;
        let imgHref = regularMatch(showDataArticle.value[i].article)
        if (imgHref != null){
          showDataArticle.value[i].imgHref = imgHref;
        }
      }
      articleViewCount.value = watchs;
      for (let i = 0; i < showDataArticle.value.length; i++) {
        for (let j = 0; j <dataStar.value.length; j++) {
          if ( showDataArticle.value[i].id === dataStar.value[i].articleId){
            showDataArticle.value[i].articleStar = dataStar.value[i].articleStar
            showDataArticle.value[i].articleWatch = dataStar.value[i].articleWatch
          }
        }
      }
    }

    onMounted(()=>{
      update();
    })

    //图片上传
    // eslint-disable-next-line no-unused-vars
    const handleUploadImage = (event, insertImage, files) => {
      const formData = new FormData()
      formData.append("file",files[0])
      uploadImg(formData);
      insertImage({
        url: data.value.url
      })
    }
    const uploadImg = async (file) => {
      data.value =  (await uploadImages(file).then()).data.data;
      console.log(data.value.url)
    }
    //md保存
    // eslint-disable-next-line no-unused-vars
    const saveText = async (text,html) => {
      let datas = {};
      let uuid = sessionStorage.getItem("uuid");
      if (uuid !== ''){
        datas = {"title":form.title,"author":"xinsin","article":text,"uuid":uuid};
      }else{
        datas = {"title":form.title,"author":"xinsin","article":text};
      }
      let data = (await saveArticle(datas).then()).data.data;
      if (data !== null){
        sessionStorage.setItem("uuid",data.uuid);
      }
    }
    //模态框开闭
    // eslint-disable-next-line no-unused-vars
    const handleClick = (tab, event) => {
      if (tab.props.name === "second"){
        dialogFormVisible.value = true;
      }
    }

    return{
      text,
      handleUploadImage,
      saveText,
      activeName,
      dialogFormVisible,
      formLabelWidth,
      form,
      handleClick,
      articleCount,
      articleViewCount,
      update,
      showDataArticle,
      zero,
      url
    }
  }
}
</script>

<style lang="less">
@import "../../common/style/globalStyle";
.el-tabs__item.is-active.is-top{
  color: @primary-color !important;
}
body{
  .bk-color;
}
.tabFirstPane{
  margin-left: 400px;
  margin-right: 400px;
}
.el-tabs--card>.el-tabs__header .el-tabs__item.is-active{
  border-bottom-color: @primary-color-background;
}
</style>