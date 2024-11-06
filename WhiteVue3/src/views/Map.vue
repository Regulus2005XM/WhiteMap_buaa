<template>
  <div>  
    <label>
      <input type="checkbox" v-model="mapSetting.enableDoubleClickZoom" />
      是否开启双击缩放？
    </label>
    <br />
    地图类型：
    <select name="" id="" v-model="type">
      <option value="BMAP_NORMAL_MAP">常规地图</option>
      <option value="BMAP_EARTH_MAP">地球模式</option>
      <option value="BMAP_SATELLITE_MAP">卫星图</option>
    </select>
    <br />
    <BMap
      :heading="5"
      :tilt="10"
      :center="{
        lng: 116.355313,
        lat: 39.986771
      }"
      :zoom="19"
      :minZoom="3"
      :maxZoom="20"
      :mapType="type"
      height="50vh"
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
    <BLabel :visible="value2"
      :content="bz"
      :position="{ lng: 116.355313,lat: 39.986771 }"
      :style="{
        color: '#fff',
        backgroundColor: '#f90',
        border: 'none',
        borderRadius: '3px',
        padding: '5px 10px',
        fontSize: '16px'
      }"
    />
    <BLocation />
      </BMap>
  </div>
  <div id="bott" height="14vh">
    <div class="flex gap-4">
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
        placeholder="搜索地点"
        @select="handleSelect"
      />
    </div>
    <el-switch v-model="value1" active-text=""
    inactive-text="显示图标"/><br/>
    <el-switch v-model="value2" active-text=""
    inactive-text="显示标记文字"/>
  </div>
  </div>
</template>

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
})
</script>

<style>
#bott{
  width : 98vw;

}

</style>