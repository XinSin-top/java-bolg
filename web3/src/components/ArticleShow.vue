<template>
  <div class="pr-text-center articleContainer">
    <img src="../assets/main.png" class="articleImg">
    <div>
      <h2 class="indexHeader"><router-link to="#">关于arch双系统安装以及初始化操作</router-link></h2>
      <p class="articleText"><router-link to="#">TOTP 基于时间的一次性密码算法（Time-Based One-Time Password）是一种根据预共享的密钥与当前时间计算一次性密码的算法，利用不同设备时间相同的特性，将时间作为特定算法的一部分从而达到无需网络进行安全验证的目的。 该算法有两个输入，一个输出，一个输入是随机生成的密钥，密钥需要被验证方和验证器同时持有，另一个输入即系统时间，通常是 UNIX 时，输出则是两方相同的验证码。一般的验证码有效期为 30 秒，每 30</router-link></p>
      <div>
        <div>
          <el-icon class="iconStyle">
            <calendar />
          </el-icon>
          <span class="iconText">123</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { Calendar } from '@element-plus/icons-vue';
export default {
  components:{
    Calendar
  }
}
</script>
<style lang="less" scoped>
@import "../common/style/globalStyle";
.iconText{
  margin: 0;
  padding: 0;
  align-items: center;
  .pr-font-family;
  .pr-font-color;
  line-height: 10px;
}
.iconStyle{
  margin-top: 15px;
}
.articleImg{
  width: 200px;
  height: 150px;
  box-shadow: 0 5px 11px 0 rgb(0 0 0 / 18%), 0 4px 15px 0 rgb(0 0 0 / 15%);
  margin-right: 15px;
  border-radius: 3px;
}
.indexHeader{
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
  height: 75px;
  float: left;
  overflow: hidden;
  margin: 0;
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
.articleContainer{
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  margin-bottom: 10px;
  div{
    width: 600px;
    //height: 150px;
    text-align: left;
  }
}
</style>