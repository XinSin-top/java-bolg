<template>
  <el-container>
    <el-header>
      <nav-bar></nav-bar>
    </el-header>
    <el-main>
      <h1 class="currentArticle">当前文章:<span>{{currentArticle}}</span></h1>
      <el-divider></el-divider>
      <v-md-preview :text="text" :include-level="[2,3,4]" default-show-toc="true" mode="preview"></v-md-preview>
    </el-main>
  </el-container>
</template>

<script>
import {onMounted, ref} from "vue";
import {selectArticleUUID} from "@/axios/request";
import {useRoute} from "vue-router";
import NavBar from "@/components/NavBar";

export default {
  name: "ArticleInfo",
  components: {NavBar},
  setup(){
    const text = ref("");
    const router = useRoute();
    const currentArticle = ref("");

    const update = async () => {
      let data = (await selectArticleUUID(router.params.uuid).then()).data.data;
      text.value = data.article;
      currentArticle.value = data.title
    }

    onMounted(() =>{
      update();
    })

    return{
      text,
      currentArticle
    }
  }
}
</script>

<style scoped lang="less">
@import "../common/style/globalStyle";

.currentArticle{
  .pr-text-center;
  .pr-font-color;
  span{
    color: @primary-color;
  }
}
.v-md-editor-preview{
  .pr-main-center;
}
</style>