<template>
    <el-form :model="form" label-width="auto" style="max-width: 600px" class="myform">
      <el-form-item label="地点名">
        <el-input v-model="form.siteName" />
      </el-form-item>

      <el-form-item label="发布到板块">
        <el-checkbox-group v-model="otherForm.type">
          <el-checkbox value="Online activities" name="type">
            生活板块
          </el-checkbox>
          <el-checkbox value="Promotion activities" name="type">
            学习板块
          </el-checkbox>
          <el-checkbox value="Offline activities" name="type">
            运动板块
          </el-checkbox>
          <el-checkbox value="Simple brand exposure" name="type">
            艺术板块
          </el-checkbox>
        </el-checkbox-group>
      </el-form-item>

      <el-form-item label="校区">
        <el-radio-group v-model="otherForm.xiaoqu">
          <el-radio value="Sponsor">学院路校区</el-radio>
          <el-radio value="Venue">沙河校区</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="具体描述">
        <el-input v-model="jiexi.inputContent" type="textarea" />
      </el-form-item>
        
      <el-form-item>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <el-button type="primary" @click="submitForm">发布</el-button>
        <el-button type="danger" @click="gotoMap">取消</el-button>
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
  <el-dialog v-model="dialogVisible">
    <img w-full :src="dialogImageUrl" alt="Preview Image" />
  </el-dialog>
    </el-form-item>
  </el-form>

  <el-form :model="form" label-width="auto" style="max-width: 600px" class="myform">
  <div class="state" v-if="!isLoading && !isError">
      <span>
        城市 - {{ location.address?.province }}-{{ location.address?.city }}-{{ location.address?.district }}-{{
          location.address?.street
        }}
      </span><br></br>
      <span>纬度 - {{ location.point?.lat }}</span><br></br>
      <span>经度 - {{ location.point?.lng }}</span><br></br>
  
      <span>定位精度 - {{ location.accuracy }}m</span>
    </div>
    <div class="state" v-else-if="isError">出错了，{{ status }}</div>
    <div class="state" v-else>定位中...</div>
    <el-button type="warning" v-if="!isLoading" @click="get">重新获取</el-button>
  </el-form>

    <BMap style="max-width: 600px" enableScrollWheelZoom ref="map" @initd="get" :center="location.point || undefined">
      <template v-if="!isLoading">
        <BMarker :position="location.point"></BMarker>
        <BCircle
          strokeStyle="solid"
          strokeColor="#0099ff"
          :strokeOpacity="0.8"
          fillColor="#0099ff"
          :fillOpacity="0.5"
          :center="location.point"
          :radius="location.accuracy"
        />
      </template>
    </BMap>

  </template>
<!-- ———————————————————————————————————————————————————————————————————————— -->
<!-- ———————————————————————————————————————————————————————————————————————— -->
<script lang="ts" setup>

import { reactive,ref } from 'vue'
import { Plus } from '@element-plus/icons-vue'
import {useRouter} from 'vue-router'
import { Delete, Download, ZoomIn } from '@element-plus/icons-vue'
import type { UploadFile } from 'element-plus'

import axios from 'axios'
  import { useBrowserLocation } from 'vue3-baidu-map-gl'
  const map = ref()
  const { get, location, isLoading, isError, status } = useBrowserLocation(null, () => {
    map.value.resetCenter()
  })
const router = useRouter();
function gotoMap() {
  router.push('/user');
}
const otherForm = reactive({
  type:'',
  xiaoqu:'',
})
const form = reactive({
  x:'',
  y:'',
  siteName:'',
  jwt:''
})
const jiexi = reactive({
  inputContent:''
})

const dialogImageUrl = ref('')
const dialogVisible = ref(false)
const disabled = ref(false)
function gotoSq() {
  router.push('/sq');
}
const submitForm = async () => {
  try {
    form.x = location.value.point.lat.toString();
    form.y = location.value.point.lng.toString();
    form.jwt = localStorage.getItem('jwt').valueOf();
    const jsonString = JSON.stringify(form);
    console.log(jsonString);
    const response = await axios.post(
      "http://localhost:8080/site",
      jsonString,
      {headers:{'Content-Type':'application/json'}});
    console.log('接收数据:',response.data);
    gotoSq();
  }catch(error){
    console.error('发送数据时出错',error);
  }
}

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
  import { BMarker } from 'vue3-baidu-map-gl';

</script>
<!-- ———————————————————————————————————————————————————————————————————————— -->
<!-- ———————————————————————————————————————————————————————————————————————— -->
<style scoped>
#bott{
  width : 60vw;
}
.footer {
    background-color: white; /* 矩形背景色 */
    color: black; /* 文字颜色 */
    padding: 20px; /* 内边距 */
    border-radius: 10px; /* 圆角 */
    text-align: center; /* 文本居中 */
    width: 100%; /* 宽度设置为100% */
    position: fixed; /* 固定定位 */
    bottom: 0; /* 持续在底部 */
    left: 0; /* 左对齐 */
    box-shadow: 0 -2px 10px rgba(0, 0, 0, 0.2); /* 阴影效果 */
}
.search-container {
    display: flex;
    align-items: center;
    background-color: white;
    border-radius: 25px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    margin:30px;
}
.search-input {
    border: none;
    padding: 10px 15px;
    font-size: 16px;
    outline: none;
    width:75%;
}
.search-button {
  border-radius: 25px;
    background-color: #f1441d;
    color: white;
    border: none;
    padding: 10px 20px;
    font-size: 16px;
    cursor: pointer;
    right:0;
    transition: background-color 0.3s;
    width:150px;
}
.search-button:hover {
    background-color: #f1441d;
}
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