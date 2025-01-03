<!-- 登录页面 -->
<!-- ———————————————————————————————————————————————————————————————————————— -->
<!-- —————————————————————————————————页面展示———————————————————————————————— -->
<!-- ———————————————————————————————————————————————————————————————————————— -->

<template>

  <!-- 滚动提示信息 -->
  <van-notice-bar left-icon="volume-o" 
  text="目前账号不能绑定手机号等，忘记密码请联系管理员进行找回，
  希望大家正常使用，不要恶意攻击本网站:D"/>

  <!-- 登录表单 -->
  <el-form :model="form" label-width="auto" style="max-width: 600px" class="myform">
  
    <el-form-item label="用户名" required>
    <el-input v-model="form.account" maxlength="20" placeholder="请输入账号名"
    show-word-limit type="text"/>
    </el-form-item>

    <el-form-item label="密码" required>
    <el-input v-model="form.password" maxlength="25" placeholder="请输入密码"
    type="password" show-password show-word-limit/>
    </el-form-item>
  
    <el-form-item>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <el-button type="primary" @click="login">登录</el-button>
    <el-button type="info" @click="gotoreg()">注册新账号</el-button>
    </el-form-item>

  </el-form>
  
</template>

<!-- ———————————————————————————————————————————————————————————————————————— -->
<!-- —————————————————————————————————代码逻辑———————————————————————————————— -->
<!-- ———————————————————————————————————————————————————————————————————————— -->

<script lang="ts" setup>

// 导入组件
import axios from 'axios'
import { reactive,ref } from 'vue'
import {useRouter} from 'vue-router'
import { ElMessage } from 'element-plus'

// 跳转到注册页面
const router = useRouter()
function gotoreg() {
  router.push('/reg');
}
// 跳转到用户页面
function gotoUser() {
  router.push('/user');
}

// 提交登录表单
const form = reactive({
  account: '',
  password: ''
})
const login = async () => {
  try {
    const jsonString = JSON.stringify(form);
    console.log(jsonString);
    const response = await axios.post(
      "http://localhost:8080/login",
      jsonString,
      {headers:{'Content-Type':'application/json'}});
    console.log('接收数据:',response.data);

    if(response.data.status=='200'){
      ElMessage({
        type: 'success',
        message: '成功登录',
      })
      const jwtToken = response.data.message; // 确保正确访问 token
      localStorage.setItem('jwt', jwtToken); // 保存 JWT
      const isLogin = "true";
      localStorage.setItem('isLog',isLogin);
      gotoUser();
    }else{
      ElMessage({
        type: 'warning',
        message: response.data.message,
      })
    }
  }catch(error){
    console.error('发送数据时出错',error);
  }
}

</script>
<!-- ———————————————————————————————————————————————————————————————————————— -->
<!-- —————————————————————————————————格式设置———————————————————————————————— -->
<!-- ———————————————————————————————————————————————————————————————————————— -->
<style scoped>
.myform {
  background-color: white;
  color: black;
  padding: 20px;
  border-radius: 10px;
  max-width: 600px;
  box-shadow: 0 -2px 10px rgba(0, 0, 0, 0.2);
  margin: 20px;
}
.avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}
.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}
.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
.avatar-uploader-icon {
  border-top: 2px dashed var(--el-border-color);
}
</style>

