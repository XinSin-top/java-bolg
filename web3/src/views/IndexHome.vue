<template>
  <el-container>
    <el-header height="370px">
      <nav-bar></nav-bar>
      <div class="pr-text-center">
        <img src="../assets/avatar.png" class="avatar_img">
      </div>
      <div class="pr-text-center">
        <el-tag round effect="plain" class="tag-border">文章数量:{{articleCount}}</el-tag>
        <el-tag round effect="plain">文章观看:{{articleViewCount}}</el-tag>
      </div>
      <h4 align="center"><a target="_blank" href="https://github.com/XinSin-top" class="github">github</a></h4>
      <h3 align="center">山有木兮木有枝,心悦君兮君不知</h3>
      <h3 align="center">Hi!这里是xinsin的博客啦</h3>
      <el-divider></el-divider>

    </el-header>
    <el-main>
      <article-show
          v-for="item in data"
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
    </el-main>
  </el-container>
</template>

<script>
  import articleShow from "@/components/ArticleShow";
  import NavBar from "@/components/NavBar";
  import {onMounted, ref} from "vue";
  import {selectArticle,selectStar} from "@/axios/request";
  import {regularMatch} from "@/common/js/global";

  export default {
    components:{articleShow,NavBar},
    setup(){
      const articleCount = ref(0);
      const articleViewCount = ref(0);
      const data = ref({});
      const dataStar = ref({});
      const url = ref("/article/")

      const update = async () => {
        data.value = (await selectArticle().then()).data.data;
        dataStar.value = (await selectStar().then()).data.data;
        articleCount.value = data.value.length;
        let watchs = 0;
        for (let i = 0; i < dataStar.value.length; i++) {
          watchs += dataStar.value[i].articleWatch;
          let imgHref = regularMatch(data.value[i].article)
          if (imgHref != null){
            data.value[i].imgHref = imgHref;
          }
        }
        articleViewCount.value = watchs;
        for (let i = 0; i < data.value.length; i++) {
          for (let j = 0; j <dataStar.value.length; j++) {
            if ( data.value[i].id === dataStar.value[i].articleId){
              data.value[i].articleStar = dataStar.value[i].articleStar
              data.value[i].articleWatch = dataStar.value[i].articleWatch
            }
          }
        }
      }

      onMounted(()=>{
        update();
      })
      return{
        articleCount,
        articleViewCount,
        update,
        data,
        dataStar,
        url,
        regularMatch
      }
    }
  }
</script>

<style lang="less" scoped>
  @import "../common/style/globalStyle";
  .avatar_img{
    margin-top: 10px;
    width: 130px;
    height: 130px;
    border-radius: 100px;
    border: 1px solid @primary-color;
  }
  .tag-border{
    margin-right: 20px;
  }
  .el-tag{
    color: @primary-color;
  }
  .el-tag--plain{
    --el-tag-border-color:@primary-color;
  }
  h3{
    .pr-font-color;
    .pr-font-family;
  }
  .github{
    text-decoration: none;
    color: #60e0b9;
    &:hover{
      text-decoration: revert;
    }
  }
  .el-header{
    padding:0;
    margin: 0;
  }
  body{
    .bk-color;
  }
  .el-main{
    .pr-main-center;
  }
</style>