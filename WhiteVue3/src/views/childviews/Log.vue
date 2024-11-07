<template>
    <van-notice-bar
  left-icon="volume-o"
  text="目前账号不能绑定手机号等，忘记密码请联系管理员进行找回，希望大家正常使用，不要恶意攻击本网站:D"
/>
    <el-form :model="form" label-width="auto" style="max-width: 600px" class="myform">
      
      <el-form-item label="用户名" required>
      <el-input v-model="form.name" 
      maxlength="10"
      placeholder="输入用户名"
      show-word-limit
      type="text"/>
      </el-form-item>

      <el-form-item label="密码" required>
      <el-input v-model="form.password1"
      maxlength="25"
      placeholder="输入密码"
      type="password"
      show-password
      show-word-limit/>
      </el-form-item>
      <el-form-item>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <el-button type="primary" @click="onSubmit">登录</el-button>
        <el-button type="info" @click="gotoreg()">注册新账号</el-button>
      </el-form-item>
  </el-form>
  
  </template>
<!-- ———————————————————————————————————————————————————————————————————————— -->
<!-- ———————————————————————————————————————————————————————————————————————— -->
  <script lang="ts" setup>
  import { reactive,ref } from 'vue'
  var star = ref(3.5);
  // do not use same name with ref
  const form = reactive({
    name: '',
    password1:'',
    password2:'',
    region: '',
    date1: '',
    date2: '',
    delivery: false,
    type: [],
    resource: '',
    desc: '大家好，我是',
  })
  
  const onSubmit = () => {
    console.log('submit!')
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
    ElMessage.error('别传啦，功能还没做呢')
    return false
  } else if (rawFile.size / 1024 / 1024 > 2) {
    ElMessage.error('别传啦，功能还没做呢')
    return false
  }
  return true
}
import { Delete, Download, ZoomIn } from '@element-plus/icons-vue'

import type { UploadFile } from 'element-plus'
import {useRouter} from 'vue-router'
const router = useRouter()
function gotoreg(){
    router.push('/reg');
}
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
    background-color: white; /* 矩形背景色 */
    color: black; /* 文字颜色 */
    padding: 20px; /* 内边距 */
    border-radius: 10px; /* 圆角 */
    max-width: 600px;
    box-shadow: 0 -2px 10px rgba(0, 0, 0, 0.2); /* 阴影效果 */
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