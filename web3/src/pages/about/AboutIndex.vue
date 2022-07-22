<template>
  <el-container>
    <el-header>
      <nav-bar></nav-bar>
    </el-header>
    <el-main>
      <h1 class="title">欢迎来到关于页面!</h1>
      <span class="text">此页面将说明本博客所使用的技术以及开源地址和开源协议</span><br>
      <span class="text">前端构建使用vue,element-plus,axios,less,v-md-editor为主要技术</span><br>
      <span class="text">后端使用springboot,mybatis为主要技术</span><br>
      <span class="text">数据库为mysql</span><br>
      <span class="text"><a href="https://github.com/XinSin-top/java-bolg">github地址</a></span><br>
      <span class="text"><a href="https://www.apache.org/licenses/LICENSE-2.0">请遵循apache licenses 2.0协议</a></span>
    </el-main>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
export default {
  components: {NavBar}
}
</script>

<style scoped lang="less">
@import "../../common/style/globalStyle";
.title{
  color: @primary-color;
  .pr-text-center
}
.text{
  color: @primary-color;
  .pr-text-center;
  a{
    color: @primary-color;
  }
}
</style>