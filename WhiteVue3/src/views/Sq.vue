<script setup lang="ts">
import { onMounted } from 'vue'
import { ref } from 'vue'
import { UserFilled } from '@element-plus/icons-vue'

import axios from 'axios'
import {useRouter} from 'vue-router'

import type { TagProps } from 'element-plus'

const router = useRouter()
onMounted(()=>{
  getSiteInfo();
})
interface RestaurantItem {
  value: string
  link: string
}
function gotocreate(){
    router.push('/pub');
}

const form = ({
  x:'',
  y:'',
  range:'',
})
let Ties = ref({
  data:[
    {siteName:'加载失败',x:'0',y:'0'}
  ]
});
const getSiteInfo = async () => {
  try {
    form.y = "116.355313";
    form.x = "39.986771";
    form.range = "30.0"
    const jsonString = JSON.stringify(form);
    console.log(jsonString);
    const response = await axios.post(
      "http://localhost:8080/site/info",
      jsonString,
      {headers:{'Content-Type':'application/json'}});
    console.log('接收数据:',response.data);
    Ties.value = response.data;
  }catch(error){
    console.error('发送数据时出错',error);
  }
}

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
const common = ref({
  title:'新地点',
  star:'5'
})
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
    <div class="search-container">
        <el-autocomplete :fetch-suggestions="querySearch"@select="handleSelect"type="text" class="search-input" placeholder="搜索..."/>
        <button class="search-button"><el-icon><Search/></el-icon>搜索</button>
    </div>
  </div>
  <van-notice-bar
  left-icon="volume-o"
  text="希望大家积极创建新地点&#128541;，不要恶意刷帖，和谐讨论，不要攻击他人，活跃用户之后可能会有奖励哦"
/>
  <!-- 展示框 -->
  <el-carousel :interval="4000" type="card" height="200px">
    <el-carousel-item v-for="(image,index) in images" :key="index" style="margin:10px">
      <img :src="image" class="image-item"/>
    </el-carousel-item>
  </el-carousel>
  <!-- 新建按钮 -->
  <div class="create-button" @click="gotocreate()">+</div>
  <div id="sqs">
  
<span v-for="(Tie, siteName) in Ties.data" :key="siteName" class="Mycard">
  <router-link :to="'/site/' + Tie.siteName">
  <el-card>
    
    
    <template #header id="mycard">
      <div class="card-header">
      <span><el-avatar :icon="UserFilled" /><h3>{{Tie.siteName}}</h3>
      <div class="flex gap-2">
    <el-tag v-for="tag in tags" :key="tag.name" closable :type="tag.type" round>
    {{ tag.name }}
    </el-tag></div></span></div>
    </template><p>经度:{{ Tie.x }}<br/>纬度:{{ Tie.y }}</p>
    <template #footer>
    <el-rate
    v-model="common.star"
    disabled
    show-score
    text-color="#ff9900"
    score-template="{value}分"
  />
    </template>
  
  </el-card>
</router-link>
</span>
</div>
<el-backtop :right="100" :bottom="100" />
</template>

<style scoped>

.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  margin: 0;
  text-align: center;
}

.Mycard{
    margin: 20px;
}
#sqs{
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(350px,1fr));
}
.search-container {
    display: flex;
    align-items: center;
    background-color: white;
    border-radius: 25px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    width:94vw;
    margin:auto;
}
.search-input {
    border: none;
    padding: 10px 15px;
    font-size: 16px;
    outline: none;
    width:85%;
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
    width:100px;
}
.search-button:hover {
    background-color: #f1441d;
}
.create-button {
    position: fixed; /* 固定位置 */
    bottom: 120px; /* 距离顶部20px */
    right: 20px; /* 距离右侧20px */
    width: 50px; /* 调整按钮宽度 */
    height: 50px; /* 调整按钮高度 */
    background-color: #f2cac9; /* 按钮背景色 */
    color: white; /* 按钮文字颜色 */
    font-size: 26px; /* 按钮文字大小 */
    display: flex; /* 使用flex布局 */
    justify-content: center; /* 水平居中 */
    align-items: center; /* 垂直居中 */
    border-radius: 50%; /* 圆形按钮 */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* 阴影效果 */
    cursor: pointer; /* 鼠标悬停为手型 */
    transition: background-color 0.3s; /* 背景颜色过渡效果 */
    z-index: 5;
}
.create-button:hover {
    background-color: #ed4845; /* 悬停时按钮的颜色变化 */
}
.image-item {
    max-width: 100%; /* 让图片宽度适应容器 */
    height: auto; /* 高度自适应，保持纵横比 */
    object-fit: contain; /* 确保图片完整显示 */
}
</style>