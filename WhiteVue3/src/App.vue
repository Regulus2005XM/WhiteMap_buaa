<template>
  <div class="common-layout">
  <header>
  <el-menu
    class="el-menu-demo"
    mode="horizontal"
    background-color="white"
    text-color="#bdaead"
    active-text-color="#f33b1f"
    :ellipsis="false"
    :collapse-transition="false"
    @select="handleSelect"
  >
  <el-menu-item index="1"><RouterLink to="/" class="RL"><el-icon>
    <MapLocation /></el-icon><b>地图</b></RouterLink></el-menu-item>
  <el-menu-item index="2"><RouterLink to="/sq" class="RL"><el-icon>
    <ChatLineSquare /></el-icon><b>广场</b></RouterLink></el-menu-item>
  <el-menu-item index="3"><RouterLink to="/user" class="RL"><el-icon>
    <CoffeeCup /></el-icon><b>我的</b></RouterLink></el-menu-item>
  </el-menu>
  </header>
  <main>
  <div id="mainPart"><RouterView /></div>
  </main>
  </div>
</template>
<!-- ———————————————————————————————————————————————————————————————————————— -->
<script setup lang="ts">
//路由导航栏
import { RouterLink, RouterView } from 'vue-router'
import {ref} from 'vue'
const handleSelect = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>
<!-- ———————————————————————————————————————————————————————————————————————— -->
<style scoped>
/* 清除默认下划线： */
a {
  text-decoration: none;
}
.router-link-active {
  text-decoration: none;
}
/* 设置主界面背景颜色和占满高度 */
#mainPart{
  background-color: white;
  height: 100%;
}
/* 响应式布局 */
.el-menu-demo{
    display: grid;
  grid-template-columns: repeat(3, 1fr);
}
.RL{
  width : 100%;
  height : 100%
}
</style>