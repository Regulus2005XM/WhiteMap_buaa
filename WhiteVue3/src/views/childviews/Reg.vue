<!-- 注册页面 -->
<!-- ———————————————————————————————————————————————————————————————————————— -->
<!-- —————————————————————————————————页面展示———————————————————————————————— -->
<!-- ———————————————————————————————————————————————————————————————————————— -->
<template>

  <el-form :model="basicForm" label-width="auto" style="max-width: 600px" class="myform">  
    <el-form-item label="账号名" required>
    <el-input v-model="basicForm.account" 
    maxlength="10"
    placeholder="输入账号名"
    show-word-limit
    type="text"/>

    </el-form-item>
    <el-form-item label="邮箱" required>
    <el-input v-model="basicForm.email" 
    maxlength="20"
    placeholder="输入您的邮箱"
    show-word-limit
    type="text"/>
    </el-form-item>
      
    <el-form-item label="密码" required>
    <el-input v-model="basicForm.password" 
    maxlength="25"
    placeholder="输入密码"
    type="password"
    show-password
    show-word-limit/>
    </el-form-item>
      
    <el-form-item label="确认密码" required>
    <el-input v-model="another.password2" 
    maxlength="30"
    placeholder="确认密码"
    type="password"
    show-password
    show-word-limit/>
    </el-form-item>
      
    <el-form-item label="昵称">
    <el-input v-model="extraForm.username" 
    maxlength="10"
    placeholder="输入你的昵称"
    show-word-limit
    type="text"/>
    </el-form-item>

    <el-form-item label="出生日期">
    <el-col :span="11">
      <el-date-picker
      v-model="extraForm.birthday"
      type="date"
      placeholder="选择日期"
      style="width: 100%"/>
    </el-col>
    </el-form-item>

    <el-form-item label="性别">
      <el-radio-group v-model="extraForm.gender">
        <el-radio value="1">男</el-radio>
        <el-radio value="2">女</el-radio>
        <el-radio value="3">其他</el-radio>
      </el-radio-group>
    </el-form-item>

    <el-form-item label="个人简介">
    <el-input v-model="extraForm.description" 
    type="textarea" />
    </el-form-item>

    <el-form-item>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <el-button type="primary" @click="submitReg">注册</el-button>
      <el-button type="success" @click="gotolog()">已有账号，立刻登录</el-button>
    </el-form-item>

  </el-form>

  <el-form class="myform">
    <el-form-item label="上传头像图片">
      <el-upload 
        action="/upload" 
        list-type="picture-card" 
        :auto-upload="false" 
        :on-change="handleChange">
        <el-icon><Plus /></el-icon>

        <template #file="{ file }">
          <div>
            <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />
            <span class="el-upload-list__item-actions">
              <span
                class="el-upload-list__item-preview"
                @click="handlePictureCardPreview(file)"
              >
                <el-icon><zoom-in /></el-icon>
              </span>
              <span
                v-if="!disabled"
                class="el-upload-list__item-delete"
                @click="handleDownload(file)"
              >
                <el-icon><Download /></el-icon>
              </span>
              <span
                v-if="!disabled"
                class="el-upload-list__item-delete"
                @click="handleRemove(file)"
              >
                <el-icon><Delete /></el-icon>
              </span>
            </span>
          </div>
        </template>
      </el-upload>
      <el-dialog v-model="dialogVisible">上传头像
        <img w-full :src="dialogImageUrl" alt="Preview Image" />
      </el-dialog>
    </el-form-item>
  </el-form>
</template>
<!-- ———————————————————————————————————————————————————————————————————————— -->
<!-- ———————————————————————————————————————————————————————————————————————— -->
<script lang="ts" setup>

import { reactive,ref } from 'vue'
import axios from 'axios'
const basicForm = reactive({
  account: '',
  password:'',
  email:'',
})
const another = reactive({
  password2:''
})
const extraForm = reactive({
  id:'',
  username:'',
  birthday:'',
  gender:'',
  description:'',
  imageFile:'',
})
import { ElMessageBox } from 'element-plus'
const submitReg = async () => {
  ElMessageBox.confirm(
    '请确定信息填写无误',
    '是否注册',
    {
      confirmButtonText: '注册',
      cancelButtonText: '取消',
      type: 'warning',
    }
  )
    .then(async () => {
      ElMessage({
        type: 'success',
        message: '成功注册',
      })
  try {
    const jsonString = JSON.stringify(basicForm);//生成一个请求(JSON字符串)
    console.log(jsonString);
    const response = await axios.post(//向后端地址发送请求，并接收数据
    "http://localhost:8080/register",//地址
    jsonString,{headers:{'Content-Type':'application/json'}});
    //请求的格式设置
    console.log('响应:',response.data);
    
    const jwtToken = response.data.data.jwt; // 确保正确访问 token
    localStorage.setItem('jwt', jwtToken); // 保存 JWT
    const isLogin = "true";
    localStorage.setItem('isLog',isLogin);
    // const userId = response.data.data.id;X 
    // extraForm.id = userId;

    // const jsonString2 = JSON.stringify(extraForm);//生成一个请求(JSON字符串)
    // console.log(jsonString2);
    // const response2 = await axios.post(//向后端地址发送请求，并接收数据
    // "http://localhost:8080/userupdate",//地址
    // jsonString2,{headers:{'Content-Type':'application/json'}});
    gotoUser();
  }catch(error){
    console.error('发送数据时出错',error);
  }
})
  .catch(() => {
      ElMessage({
        type: 'info',
        message: '取消注册',
      })
    })
}
  import { ElMessage } from 'element-plus'
import { Plus } from '@element-plus/icons-vue'
import { Delete, Download, ZoomIn } from '@element-plus/icons-vue'
import {useRouter} from 'vue-router'
const handleChange = (file, fileList) => {
    // 将上传的文件对象赋值给 extraForm.imageFile
    if (file.status === 'success') {
        extraForm.imageFile = file.response ? file.response.url : file.url; // 假设你会在服务器返回文件的 URL
    } else if (file.status === 'error') {
  }
};
const router = useRouter()
function gotolog(){
    router.push('/log');
}
import type { UploadFile } from 'element-plus'

const dialogImageUrl = ref('')
const dialogVisible = ref(false)
const disabled = ref(false)

const handleRemove = (file: UploadFile) => {
  console.log(file)
}

const handlePictureCardPreview = (file: UploadFile) => {
  dialogImageUrl.value = file.url!
  dialogVisible.value = true
}

const handleDownload = (file: UploadFile) => {
  console.log(file)
}
function gotoUser() {
  router.push('/user');
}
</script>
<!-- ———————————————————————————————————————————————————————————————————————— -->
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