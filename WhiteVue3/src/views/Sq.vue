<script setup lang="ts">
import { onMounted } from 'vue'
import { ref } from 'vue'
import { UserFilled } from '@element-plus/icons-vue'
interface RestaurantItem {
  value: string
  link: string
}
var Ties = [{
  name:"匿名用户",
  title:"东区食堂新增美食",
  star:"3.5",
  context:"好吃，爱吃"
},{
  name:"小明",
  title:"羽毛球场求搭子",
  star:"4.5",
  context:"有没有人来打羽毛球啊，求求"
}]
var starvalue = ref(4.5)
const state1 = ref('')
const state2 = ref('')
const images = ref([
    '/pict/1.jpg',
    '/pict/2.jpg',
    '/pict/3.jpg',
    '/pict/4.jpg'
]);
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
    <el-carousel :interval="4000" type="card" height="20vh">
    <el-carousel-item v-for="(image,index) in images" :key="index" style="margin:10px">
      <img :src="image" class="image-item"/>
    </el-carousel-item>
  </el-carousel>
  

  <div id="sqs">
  
<span v-for="(Tie, index) in Ties" :key="index" class="Mycard">
  <el-card>
    <template #header id="mycard">
      <div class="card-header">
      <span><el-avatar :icon="UserFilled" />{{Tie.name}}<h3>{{ Tie.title }}</h3>
      <div class="flex gap-2">
    <el-tag v-for="tag in tags" :key="tag.name" closable :type="tag.type" round>
    {{ tag.name }}
    </el-tag></div></span></div>
    </template><p>{{ Tie.context }}</p>
    <template #footer>校内·东区食堂
    <el-rate
    v-model="Tie.star"
    disabled
    show-score
    text-color="#ff9900"
    score-template="{value} 分"
  />
    </template>
  </el-card>
</span>
</div>



<el-backtop :right="100" :bottom="100" />
</template>

<style scoped>
.image-item {
    max-width: 100%; /* 适应容器宽度 */
    height: auto;    /* 保持纵横比 */
    object-fit: contain; /* 使图片完全显示，保持比例，空白部分用背景色填充 */
}
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
    margin: 20px;
}
#sqs{
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(350px,1fr));
}
</style>