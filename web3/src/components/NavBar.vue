<template>
  <el-menu :default-active="router.currentRoute.value.path"
           mode="horizontal"
           router
           class="bk-color"
  >
    <el-menu-item index="/">首页</el-menu-item>
    <div style="flex-grow: 0.99;" />
    <el-menu-item index="/classification">分类</el-menu-item>
    <el-menu-item index="/about">关于</el-menu-item>
    <el-button @click="dialogFormVisible = true,verify()" color="#0dbd76" size="large" class="editorBtn">编辑</el-button>
  </el-menu>
  <el-dialog v-model="dialogFormVisible" title="登录">
    <el-form :model="form">
      <el-form-item label="帐号:" :label-width="formLabelWidth">
        <el-input v-model="form.username" autocomplete="off" />
      </el-form-item>
      <el-form-item label="密码" :label-width="formLabelWidth">
        <el-input v-model="form.password" autocomplete="off" show-password/>
      </el-form-item>
      <el-form-item label="验证码" :label-width="formLabelWidth">
<!--          验证码代码还没有写-->
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false,editorJump()">确认</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script>
import {useRouter} from "vue-router";
import { reactive, ref } from 'vue'
import {login,tokenVerify} from "@/axios/request";
import md5_hex from 'js-md5';
import { ElMessage } from 'element-plus'

export default {
  setup(){
    const router = useRouter();
    const dialogFormVisible = ref(false);
    const formLabelWidth = ref('120px');
    const form = reactive({
      username:'',
      password:''
    });
    //todo 此处代码应该有token验签
    const editorJump = () => {
      update();
    }
    const verify = async () => {
      let token = localStorage.getItem("token");
      if (token !== null && token !== "undefined"){
        let data = (await tokenVerify().then()).data;
        if (data.data.verify === "success"){
          router.push("/editor")
        }else{
          localStorage.clear();
        }
      }
    }
    const update = async() =>{
      form.password = md5_hex(form.password);
      let data = (await login(form).then()).data.data;
      if (data.canLogin === true){
        ElMessage.success("登录成功正在进行跳转!")
        router.push("/editor")
      }else{
        ElMessage.error("帐号或密码错误,请重新登录!")
        form.username = '';
        form.password = '';

      }
    }
    return {
      router,
      editorJump,
      dialogFormVisible,
      formLabelWidth,
      form,
      verify
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
  .editorBtn{
    width: 200px;
    height: 40px;

  }
</style>