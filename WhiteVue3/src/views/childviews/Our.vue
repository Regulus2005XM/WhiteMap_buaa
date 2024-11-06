<script setup lang="ts">
import { onMounted } from 'vue'
import { ref } from 'vue'
import { UserFilled } from '@element-plus/icons-vue'
interface RestaurantItem {
  value: string
  link: string
}
var starvalue = ref(4.5)
const state1 = ref('')
const state2 = ref('')
const restaurants = ref<RestaurantItem[]>([])
const querySearch = (queryString: string, cb: any) => {
  const results = queryString
    ? restaurants.value.filter(createFilter(queryString))
    : restaurants.value
  // call callback function to return suggestions
  cb(results)
}
const createFilter = (queryString: string) => {
  return (restaurant: RestaurantItem) => {
    return (
      restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0
    )
  }
}
const loadAll = () => {
  return [
    { value: '食堂', link: '' },
    { value: '自习室', link: '' },
    { value: '运动区', link: '' },
    { value: '风景', link: '' },
    { value: '超市', link: '' },
    { value: '饭店', link: '' },
  ]
}

const handleSelect = (item: RestaurantItem) => {
  console.log(item)
}

onMounted(() => {
  restaurants.value = loadAll()
})

import type { TagProps } from 'element-plus'

interface TagsItem {
  name: string
  type: TagProps['type']
}

const tags = ref<TagsItem[]>([
  { name: '食堂', type: 'primary' },
  { name: '建筑内', type: 'success' },
])
</script>

<template>
  <div>
  <div class="sub-title my-2 text-sm text-gray-600">
        <el-icon><Search /></el-icon>
        搜索
      </div>
      
      <el-autocomplete
        v-model="state1"
        :fetch-suggestions="querySearch"
        clearable
        class="inline-input w-50"
        placeholder="输入内容"
        @select="handleSelect"
      />
    </div>
    <div>最近热点：</div>
    <el-carousel :interval="4000" type="card" height="200px">
    <el-carousel-item v-for="item in 4" :key="item" style="margin:10px">
      <h3 text="2xl" justify="center"style="margin:10px">{{ item }}</h3>
    </el-carousel-item>
  </el-carousel>
  


  <span class="Mycard">
  <el-card>
    <template #header id="mycard">
      <div class="card-header">
        <span><el-avatar :icon="UserFilled" />匿名用户<h3>食堂新增档口</h3>
            <div class="flex gap-2">
    <el-tag v-for="tag in tags" :key="tag.name" closable :type="tag.type" round>
      {{ tag.name }}
    </el-tag>
  </div>
        </span>
      </div>
    </template>
    <p>食堂新增了一个档口，感觉还不错</p>
    <template #footer>校内·东区食堂
        <el-rate
    v-model="starvalue"
    disabled
    show-score
    text-color="#ff9900"
    score-template="{value} 分"
  />
    </template>
  </el-card>
</span>
<span class="Mycard">
  <el-card>
    <template #header id="mycard">
      <div class="card-header">
        <span><el-avatar :icon="UserFilled" />匿名用户<h3>食堂新增档口</h3>
            <div class="flex gap-2">
    <el-tag v-for="tag in tags" :key="tag.name" closable :type="tag.type" round>
      {{ tag.name }}
    </el-tag>
  </div>
        </span>
      </div>
    </template>
    <p>食堂新增了一个档口，感觉还不错</p>
    <template #footer>校内·东区食堂
        <el-rate
    v-model="starvalue"
    disabled
    show-score
    text-color="#ff9900"
    score-template="{value} 分"
  />
    </template>
  </el-card>
</span>
<span class="Mycard">
  <el-card>
    <template #header id="mycard">
      <div class="card-header">
        <span><el-avatar :icon="UserFilled" />匿名用户<h3>食堂新增档口</h3>
            <div class="flex gap-2">
    <el-tag v-for="tag in tags" :key="tag.name" closable :type="tag.type" round>
      {{ tag.name }}
    </el-tag>
  </div>
        </span>
      </div>
    </template>
    <p>食堂新增了一个档口，感觉还不错</p>
    <template #footer>校内·东区食堂
        <el-rate
    v-model="starvalue"
    disabled
    show-score
    text-color="#ff9900"
    score-template="{value} 分"
  />
    </template>
  </el-card>
</span>
<span class="Mycard">
  <el-card>
    <template #header id="mycard">
      <div class="card-header">
        <span><el-avatar :icon="UserFilled" />匿名用户<h3>食堂新增档口</h3>
            <div class="flex gap-2">
    <el-tag v-for="tag in tags" :key="tag.name" closable :type="tag.type" round>
      {{ tag.name }}
    </el-tag>
  </div>
        </span>
      </div>
    </template>
    <p>食堂新增了一个档口，感觉还不错</p>
    <template #footer>校内·东区食堂
        <el-rate
    v-model="starvalue"
    disabled
    show-score
    text-color="#ff9900"
    score-template="{value} 分"
  />
    </template>
  </el-card>
</span>
<span class="Mycard">
  <el-card>
    <template #header id="mycard">
      <div class="card-header">
        <span><el-avatar :icon="UserFilled" />匿名用户<h3>食堂新增档口</h3>
            <div class="flex gap-2">
    <el-tag v-for="tag in tags" :key="tag.name" closable :type="tag.type" round>
      {{ tag.name }}
    </el-tag>
  </div>
        </span>
      </div>
    </template>
    <p>食堂新增了一个档口，感觉还不错</p>
    <template #footer>校内·东区食堂
        <el-rate
    v-model="starvalue"
    disabled
    show-score
    text-color="#ff9900"
    score-template="{value} 分"
  />
    </template>
  </el-card>
</span>



<el-backtop :right="100" :bottom="100" />
</template>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}

.Mycard{
    display: flex;
    margin: 40px;
}
</style>