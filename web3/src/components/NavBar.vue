<template>
  <el-menu :default-active="router.currentRoute.value.path"
           mode="horizontal"
           router
           class="bk-color"
  >
    <el-menu-item index="/">首页</el-menu-item>
    <div style="flex-grow: 1;" />
    <el-menu-item index="/classification">分类</el-menu-item>
    <el-menu-item index="/about">关于</el-menu-item>
    <el-menu-item index="/editor">编辑</el-menu-item>
  </el-menu>
</template>

<script>
import {useRouter} from "vue-router";

export default {
  setup(){
    const router = useRouter();
    console.log(router.currentRoute.value.path);
    return {
      router
    }
  }
}
</script>

<style scoped lang="less">
  @import "../common/style/globalStyle";
  .el-menu--horizontal>.el-menu-item.is-active{
    border-bottom: 2px solid @primary-color;
    color: @primary-color !important;
  }
</style>