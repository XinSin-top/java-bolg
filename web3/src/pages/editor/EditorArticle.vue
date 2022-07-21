<template>
  <el-container>
    <el-header>
      <nav-bar></nav-bar>
    </el-header>
    <el-main>
      <v-md-editor
          v-model="text"
          :disabled-menus="[]"
          height="800px"
          @upload-image="handleUploadImage"
          left-toolbar="undo redo clear | h bold italic strikethrough quote | ul ol table hr | link image code | save | tip | emoji | editTitle"
          @save="saveText"
          :toolbar="toolbar"
      >
      </v-md-editor>
    </el-main>
    <el-dialog v-model="dialogFormVisible" title="修改文章标题">
      <el-form :model="form">
        <el-form-item label="文章标题" :label-width="formLabelWidth">
          <el-input v-model="form.title" autocomplete="off" />
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消更改</el-button>
        <el-button type="primary" @click="dialogFormVisible = false , confirmChangeTitle()">确认更改</el-button>
      </span>
      </template>
    </el-dialog>
  </el-container>
</template>

<script>
import {saveArticle, selectArticleUUID, uploadImages} from "@/axios/request";
import {ref, onMounted, reactive} from "vue";
import {useRoute} from "vue-router";
import NavBar from '@/components/NavBar'

export default {
  name: "EditorArticle",
  components:{
    NavBar
  },
  setup(){
    const text = ref("");
    const data = ref();
    const router = useRoute();
    const title = ref();
    const dialogFormVisible = ref(false);
    const formLabelWidth = ref("120px")
    const form = reactive({
      title: '',
    });

    const confirmChangeTitle = async () => {
      let data = (await saveArticle({"title":form.title,"author":"xinsin","article":text.value,"uuid":sessionStorage.getItem("uuid")}).then()).data.data;
      form.title = data.title;
      title.value = data.title;
    }

    const toolbar = reactive({
      editTitle:{
        title: '更改标题',
        icon: 'v-md-icon-tip',
        action(){
          dialogFormVisible.value = true;
          form.title = title.value;
        }
      }
    })

    const update = async () => {
      let data = (await selectArticleUUID(router.params.uuid).then()).data.data;
      text.value = data.article;
      title.value = data.title;
      sessionStorage.setItem("uuid",data.uuid)
    }

    onMounted(() =>{
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
      data.value = (await uploadImages(file).then()).data.data;
    }
    //md保存
    // eslint-disable-next-line no-unused-vars
    const saveText = async (text,html) => {
      let datas = {};
      let uuid = sessionStorage.getItem("uuid");
      if (uuid !== ''){
        datas = {"title":title.value,"author":"xinsin","article":text,"uuid":uuid};
      }else{
        datas = {"title":title.value,"author":"xinsin","article":text};
      }
      let data = (await saveArticle(datas).then()).data.data;
      if (uuid == null && uuid === "undefined" && data !== {}){
        sessionStorage.setItem("uuid",data.uuid);
      }
    }
    return{
      text,
      saveText,
      handleUploadImage,
      toolbar,
      dialogFormVisible,
      formLabelWidth,
      form,
      confirmChangeTitle
    }
  }
}
</script>

<style scoped lang="less">
@import "../../common/style/globalStyle";
html{
  .bk-color;
}
</style>