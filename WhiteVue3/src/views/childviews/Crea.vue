<template>
    <el-form :model="form" label-width="auto" style="max-width: 600px" class="myform">
      <el-form-item label="标题">
        <el-input v-model="form.name" />
      </el-form-item>
      <el-form-item label="帖子类型">
        <el-select v-model="form.region" placeholder="填入你的贴子类型">
          <el-option label="新建一个地点" value="shanghai" />
          <el-option label="评价已有地点" value="beijing" />
        </el-select>
      </el-form-item>
      <el-form-item label="活动时间">
        <el-col :span="11">
          <el-date-picker
            v-model="form.date1"
            type="date"
            placeholder="选择日期"
            style="width: 100%"
          />
        </el-col>
        <el-col :span="4" class="text-center">
          <span class="text-gray-500">-</span>
        </el-col>
        <el-col :span="11">
          <el-time-picker
            v-model="form.date2"
            placeholder="选择时间"
            style="width: 100%"
          />
        </el-col>
      </el-form-item>
      <el-form-item label="不公开">
        <el-switch v-model="form.delivery" />
      </el-form-item>
      <el-form-item label="发布到板块">
        <el-checkbox-group v-model="form.type">
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
        <el-radio-group v-model="form.resource">
          <el-radio value="Sponsor">学院路校区</el-radio>
          <el-radio value="Venue">沙河校区</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="帖子内容">
        <el-input v-model="form.desc" type="textarea" />
      </el-form-item>
      <el-form-item label="给地点打分">
        <el-rate v-model="star" allow-half />
        </el-form-item>
        
      <el-form-item>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <el-button type="primary" @click="onSubmit">发布</el-button>
        <el-button>取消</el-button>
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
  </template>
<!-- ———————————————————————————————————————————————————————————————————————— -->
<!-- ———————————————————————————————————————————————————————————————————————— -->
  <script lang="ts" setup>
  import { reactive,ref } from 'vue'
  var star = ref(3.5);
  // do not use same name with ref
  const form = reactive({
    name: '',
    region: '',
    date1: '',
    date2: '',
    delivery: false,
    type: [],
    resource: '',
    desc: '向大家推荐',
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