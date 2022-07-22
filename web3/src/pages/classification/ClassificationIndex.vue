<template>
  <el-container>
    <el-header>
      <nav-bar></nav-bar>
    </el-header>
    <el-main>
      <h1 class="title">当前页面正在编辑中</h1>
      <p class="text">
        xinsin正在(加班加点)编写中<br>
        并不知道什么时候能写完![也不一定什么时候写]
      </p>
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
  .pr-text-center
}
</style>