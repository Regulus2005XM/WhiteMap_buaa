<template>
  <div class="container1">  
    <div>
    <BMap
      :heading="5"
      :tilt="10"
      :center="{
        lng: 116.355313,
        lat: 39.986771
      }"
      height="400px"
      :zoom="19"
      :minZoom="3"
      :maxZoom="24"
      :mapType="type"
      :enableAutoResize="mapSetting.enableAutoResize"
      :enableDrgging="mapSetting.enableDragging"
      :enableInertialDragging="mapSetting.enableInertialDragging"
      :enableScrollWheelZoom="mapSetting.enableScrollWheelZoom"
      :enableContinuousZoom="mapSetting.enableContinuousZoom"
      :enableDoubleClickZoom="mapSetting.enableDoubleClickZoom"
      :enableKeyboard="mapSetting.enableKeyboard"
      :enablePinchToZoom="mapSetting.enablePinchToZoom"
      :enableTraffic="mapSetting.enableTraffic"
    >
      <BMarker :visible="value1" :position="{ lng: 116.355313,lat: 39.986771 }" icon="red1" />

      <div v-for="(Tie, siteName) in Ties.data" :key="siteName">
      <BLabel :visible="value2"  :content="Tie.siteName":position="{ lng: parseFloat(Tie.y),lat: parseFloat(Tie.x) }"
      :style="{color: '#fff', backgroundColor: '#f90',border: 'none',
        borderRadius: '3px',padding: '5px 10px',fontSize: '16px'}"/>
      </div>
      <BLocation />
    </BMap>
    </div>
  
    <div class="footer">
      <div class="flex gap-4">
      <label>
      <input type="checkbox" v-model="mapSetting.enableDoubleClickZoom" />
      开启双击缩放
      </label>
      <select name="" id="" v-model="type">
      <option value="BMAP_NORMAL_MAP">常规地图</option>
      <option value="BMAP_EARTH_MAP">地球模式</option>
      <option value="BMAP_SATELLITE_MAP">卫星图</option>
      </select>
      <br/>
      <div class="search-container">
        <el-autocomplete :fetch-suggestions="querySearch"@select="handleSelect"type="text" class="search-input" placeholder="搜索..."/>
        <button class="search-button"><el-icon><Search/></el-icon>搜索</button>
      </div>
      <el-switch v-model="value1" active-text="显示图标&nbsp;&nbsp;&nbsp;"inactive-text=""/>
      <el-switch v-model="value2" active-text="显示标记文字"inactive-text=""/>
      </div>
    </div>
  </div>
</template>
<!-- ———————————————————————————————————————————————————————————————————————— -->
<!-- ———————————————————————————————————————————————————————————————————————— -->
<script setup lang="ts">
  import { ref } from 'vue'
  import type { MapType, MapProps } from 'vue3-baidu-map-gl';
  import { BMarker } from 'vue3-baidu-map-gl';
  import { BLocation } from 'vue3-baidu-map-gl'
  import { BLabel } from 'vue3-baidu-map-gl'
  var bz = "欢迎使用北航白泽地图"
  const value1 = ref(true)
  const value2 = ref(true)
  const type = ref<MapType>('BMAP_NORMAL_MAP')
  const mapSetting = ref<MapProps>({
    enableDragging: true,
    enableInertialDragging: true,
    enableScrollWheelZoom: false,
    enableContinuousZoom: true,
    enableResizeOnCenter: true,
    enableDoubleClickZoom: false,
    enableKeyboard: true,
    enablePinchToZoom: true,
    enableAutoResize: true,
    enableTraffic: false
  })
  import { onMounted } from 'vue'

interface RestaurantItem {
  value: string
  link: string
}

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
  getSiteInfo();
})


// 查询接口

import axios from 'axios'
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

</script>
<!-- ———————————————————————————————————————————————————————————————————————— -->
<!-- ———————————————————————————————————————————————————————————————————————— -->
<style>

#bott{
  width : 98vw;
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
</style>