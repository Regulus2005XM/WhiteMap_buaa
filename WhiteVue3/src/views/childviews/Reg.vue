<template>
    <el-form :model="form" label-width="auto" style="max-width: 600px" class="myform">
      <!-- 1 -->
      <el-form-item label="用户名" required>
      <el-input v-model="formTrue.account" 
      maxlength="10"
      placeholder="输入用户名"
      show-word-limit
      type="text"/>
      </el-form-item>
      <el-form-item label="邮箱" required>
      <el-input v-model="formTrue.email" 
      maxlength="20"
      placeholder="输入您的邮箱"
      show-word-limit
      type="text"/>
      </el-form-item>
      <!-- 2 -->
      <el-form-item label="密码" required>
      <el-input v-model="formTrue.password" 
      maxlength="25"
      placeholder="输入密码"
      type="password"
      show-password
      show-word-limit/>
      </el-form-item>
      <!-- 3 -->
      <el-form-item label="确认密码" required>
      <el-input v-model="form.password2" 
      maxlength="30"
      placeholder="确认密码"
      type="password"
      show-password
      show-word-limit/>
      </el-form-item>
      <!-- 4 -->
      <el-form-item label="出生日期">
      <el-col :span="11">
        <el-date-picker
        v-model="form.date"
        type="date"
        placeholder="选择日期"
        style="width: 100%"/>
      </el-col>
      <!-- 5 -->
      </el-form-item>
      <el-form-item label="性别">
        <el-radio-group v-model="form.sex">
          <el-radio value="male">男</el-radio>
          <el-radio value="female">女</el-radio>
          <el-radio value="other">其他</el-radio>
        </el-radio-group>
      </el-form-item>
      <!-- 6 -->
      <el-form-item label="个人简介">
        <el-input v-model="form.desc" type="textarea" />
      </el-form-item>
      <el-form-item>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <el-button type="primary" @click="submitReg">注册</el-button>
        <el-button type="success" @click="gotolog()">已有账号，立刻登录</el-button>
      </el-form-item>
  </el-form>
  <el-form class="myform">
    <el-form-item label="上传图片">
      <el-upload action="#" list-type="picture-card" :auto-upload="false">
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
var star = ref(3.5);
const form = reactive({
  password2:'',
  date: '2005-1-1',
  sex: 'other',
  delivery: false,
  type: [],
  desc: '大家好，我是',
  })
const formTrue = reactive({
  account: '',
  password:'',
  email:'',
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
    const jsonString = JSON.stringify(formTrue);//生成一个请求(JSON字符串)
    console.log(jsonString);
    const response = await axios.post(//向后端地址发送请求，并接收数据
    "http://localhost:8080/register",//地址
    jsonString,{headers:{'Content-Type':'application/json'}});
    //请求的格式设置
    console.log('响应:',response.data);
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

import type { UploadProps } from 'element-plus'

const imageUrl = ref('')

const handleAvatarSuccess: UploadProps['onSuccess'] = (
  response,
  uploadFile
) => {
  imageUrl.value = URL.createObjectURL(uploadFile.raw!)
}

const beforeAvatarUpload: UploadProps['beforeUpload'] = (rawFile) => {
  if (rawFile.type !== 'image/jpeg') {
    ElMessage.error('图片上传失败')
    return false
  } else if (rawFile.size / 1024 / 1024 > 2) {
    ElMessage.error('图片文件过大')
    return false
  }
  return true
}
import { Delete, Download, ZoomIn } from '@element-plus/icons-vue'
import {useRouter} from 'vue-router'
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