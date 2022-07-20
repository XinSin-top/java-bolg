<template>
  <el-container>
    <el-header>
    </el-header>
    <el-main>
      <el-tabs
          v-model="activeName"
          type="card"
          class="demo-tabs"
          @tab-click="handleClick"
      >
        <el-tab-pane label="查看文章" name="first"></el-tab-pane>
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
import {uploadImages,saveArticle} from "@/axios/request";

export default {

  setup(){
    const text = ref("" +
        "``` java\n" +
        "public static void main(String[] args){\n" +
        "\n" +
        "}\n" +
        "```");
    const data = ref();
    const activeName = ref("first");
    const dialogFormVisible = ref(false);
    const formLabelWidth = ref("120px")
    const form = reactive({
      title:""
    })

    // eslint-disable-next-line no-unused-vars
    const handleUploadImage = (event, insertImage, files) => {
      const formData = new FormData()
      console.log(files);
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
    }
  }
}
</script>

<style lang="less">
@import "../../common/style/globalStyle";
.el-tabs__item.is-active.is-top{
  color: @primary-color !important;
}
</style>