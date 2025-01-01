<template>
    <el-badge :value="7" class="item" type="warning">
      <el-button>系统通知</el-button>
    </el-badge>
    <el-badge :value="2" class="item" color="green">
      <el-button>关注的人</el-button>
    </el-badge>
    <el-badge :value="12" class="item">
      <el-button>评论</el-button>
    </el-badge>
    <el-badge :value="3" class="item">
      <el-button>回复</el-button>
    </el-badge>
    <el-badge :value="1" class="item" type="primary">
      <el-button>@我</el-button>
    </el-badge>
    
    <div v-if="!isLoggedIn">
    <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
    <el-tab-pane label="主页" name="first">
        <el-col :sm="12" :lg="6">
      <el-result
        icon="error"
        title="您还未注册"
        sub-title="注册暂时无需手机号验证等"
      >
        <template #extra>
          <el-button color="#626aef" @click="gotoreg()">现在注册</el-button>
          <el-button type="primary" @click="gotolog()">已有账号，立刻登录</el-button>
        
          <el-form :model="loginForm" label-width="auto" style="max-width: 600px" class="myform">
      
      <el-form-item label="输入用户id进行信息查询" required>
      <el-input v-model="loginForm.id0" 
      maxlength="20"
      placeholder="按注册顺序从1开始"
      show-word-limit
      type="text"/>
      </el-form-item>
      <el-form-item>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <el-button type="primary" @click="handleLogin">查询</el-button>
      </el-form-item>
  </el-form>
    </template>
      </el-result>
    </el-col>
    </el-tab-pane>
    <el-tab-pane label="收藏" name="second">收藏</el-tab-pane>
    <el-tab-pane label="关注" name="third">关注</el-tab-pane>
    <el-tab-pane label="历史记录" name="fourth">历史记录</el-tab-pane>
  </el-tabs>
  </div>
  <!-- 已登录 -->
  <div v-else>
    <h2>欢迎</h2>
        <el-list>
          <el-list-item>账号: {{ user.account }}</el-list-item>
          <el-list-item>账号: {{ user.email }}</el-list-item>
        </el-list>
        <el-button type="primary" @click="logout">登出</el-button>
  </div>
  </template>
  
  <script lang="ts" setup>
  import { CaretBottom } from '@element-plus/icons-vue'
import type { TabsPaneContext } from 'element-plus'

const activeName = ref('first')

const handleClick = (tab: TabsPaneContext, event: Event) => {
  console.log(tab, event)
}
function gotoreg(){
    router.push('/reg');
}
function gotolog(){
    router.push('/log');
}
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios'
const user = ref(null)
const isLoggedIn = ref(false)
const errorMessage = ref('')
const router = useRouter()
const loginForm = ref({
  id0: ''
})
const handleLogin = async () => {
  errorMessage.value = ''
  try {
    const id1 = loginForm.value.id0
    console.log("start")
    const response = await axios.get('http://localhost:8080/userget',{params:{id:id1}});
    user.value = response.data.data // 获取用户信息
    isLoggedIn.value = true
  } catch (error) {
    console.error('接收数据时出错',error);
  }
}
const logout = () => {
  user.value = null
  isLoggedIn.value = false
  loginForm.value = { id0:'' }
  router.push('/') // 回到首页
}
  </script>
  
<style scoped>
.demo-tabs > .el-tabs__content {
  padding: 32px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}
.item {
    margin-top: 10px;
    margin-right: 30px;
}
.el-dropdown {
    margin-top: 1.1rem;
}
</style>