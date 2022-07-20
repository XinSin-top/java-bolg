<template>
  <div class="pr-text-center articleContainer">
    <div class="indexImg"><img :src="imgHref" class="articleImg"  alt="这是一张图片"/></div>
    <div style="margin-right: auto !important;">
      <h2 class="indexHeader"><router-link :to="href">{{title}}</router-link></h2>
      <p class="articleText"><router-link :to="href">{{text}}</router-link></p>
      <div>
        <div class="indexBtm">
          <el-icon class="iconStyle">
            <calendar />
          </el-icon>
          <span class="iconText">{{date}}</span>
        </div>
        <div class="indexBtm">
          <el-icon class="iconStyle">
            <star />
          </el-icon>
          <span class="iconText">{{star}}</span>
        </div>
        <div class="indexBtm">
          <el-icon class="iconStyle">
            <user />
          </el-icon>
          <span class="iconText">{{author}}</span>
        </div>
        <div class="indexBtm">
          <el-icon class="iconStyle">
            <view />
          </el-icon>
          <span class="iconText">{{watch}}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { Calendar,Star,User,View } from '@element-plus/icons-vue';


export default {
  components:{
    Calendar,
    Star,
    // eslint-disable-next-line vue/no-unused-components
    View,
    User,
  },
  props:{
    title: String,
    text:String,
    href:String,
    imgHref:String,
    date:String,
    star:String,
    author:String,
    watch:String,
  }
}
</script>
<style lang="less" scoped>
@import "../common/style/globalStyle";
.articleContainer{
  display: flex;
  margin-bottom: 10px;
  margin-right: auto !important;
}
.indexBtm{
  display: flex;
  margin-top: 5px;
  i, span {
    display: inherit;
    vertical-align: middle;
    line-height: 10px;
  }
}
.indexImg{
  margin-right: auto !important;
}
.iconText{
  margin: 0;
  padding: 0;
  align-items: center;
  .pr-font-family;
  .pr-font-color;
  line-height: 10px;
}
.iconStyle{
  // margin-top: 15px;
}
.articleImg{
  width: 200px;
  box-shadow: 0 5px 11px 0 rgb(0 0 0 / 18%), 0 4px 15px 0 rgb(0 0 0 / 15%);
  margin-right: 15px;
  border-radius: 3px;
}
.indexHeader{
  text-align: left;
  .pr-font-family;
  margin: 0 0 10px;
  a{
    color: black;
    text-decoration: none;
    .pr-font-family;
    .pr-font-color;
    font-size: 25px;
    font-weight: bold;
    &:hover{
      transition: color 2s;
      color:@primary-color;
    }
  }
}
.articleText{
  // height: 75px;
  // float: left;
  margin: 0;
  text-align: left;
  a{
    color: black;
    text-decoration: none;
    .pr-font-family;
    .pr-font-color;
    &:hover{
      transition: color 2s;
      color:@primary-color;
    }
  }
}
</style>