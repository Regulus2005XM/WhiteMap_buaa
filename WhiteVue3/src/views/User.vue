<template>
    <el-badge :value="12" class="item">
      <el-button>评论</el-button>
    </el-badge>
    <el-badge :value="3" class="item">
      <el-button>回复</el-button>
    </el-badge>
    <el-badge :value="1" class="item" type="primary">
      <el-button>@我</el-button>
    </el-badge>
    <el-badge :value="7" class="item" type="warning">
      <el-button>系统通知</el-button>
    </el-badge>
    <el-badge :value="2" class="item" color="green">
      <el-button>关注的人</el-button>
    </el-badge>
    



    <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
    <el-tab-pane label="主页" name="first">
        <el-col :sm="12" :lg="6">
      <el-result
        icon="error"
        title="您还未注册"
        sub-title="测试阶段，注册功能尚未开启"
      >
        <template #extra>
          <el-button type="primary">关注后续消息</el-button>
        </template>
      </el-result>
    </el-col>
    </el-tab-pane>
    <el-tab-pane label="收藏" name="second">收藏</el-tab-pane>
    <el-tab-pane label="关注" name="third">关注</el-tab-pane>
    <el-tab-pane label="历史记录" name="fourth">历史记录</el-tab-pane>
  </el-tabs>
  </template>
  
  <script lang="ts" setup>
  import { CaretBottom } from '@element-plus/icons-vue'
  import { ref } from 'vue'
import type { TabsPaneContext } from 'element-plus'

const activeName = ref('first')

const handleClick = (tab: TabsPaneContext, event: Event) => {
  console.log(tab, event)
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
  