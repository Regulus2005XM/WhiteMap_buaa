<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import {ref} from 'vue'
const activeIndex = ref('1')
const activeIndex2 = ref('1')
const handleSelect = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>


<!-- —————————————————————————————————————————————————————————— -->
<template>
  <div class="common-layout">
  <header>
  <el-menu
    :default-active="activeIndex2"
    class="el-menu-demo"
    mode="horizontal"
    background-color="#E8FAFF"
    text-color="#263238"
    active-text-color="#29B6F6"
    :ellipsis="false"
    :collapse-transition="false"
    @select="handleSelect"
  >
  <el-menu-item index="1"><RouterLink to="/" class="RL"><el-icon>
    <MapLocation /></el-icon>地图</RouterLink></el-menu-item>
  <el-menu-item index="2"><RouterLink to="/sq" class="RL"><el-icon>
    <ChatLineSquare /></el-icon>广场</RouterLink></el-menu-item>
  <el-menu-item index="5"><RouterLink to="/user" class="RL"><el-icon>
    <CoffeeCup /></el-icon>我的</RouterLink></el-menu-item>
  
  </el-menu>
  </header>
  <main>
    <div id="mainPart"><RouterView /></div>
  </main>
  </div>
</template>

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
  background-color: #FDFDFD;
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