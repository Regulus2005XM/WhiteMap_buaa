import { createApp } from 'vue'
import { createPinia } from 'pinia'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

import App from './App.vue'
import router from './router'
import Vue3BaiduMapGL from 'vue3-baidu-map-gl'
import baiduMap from 'vue3-baidu-map-gl'

const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
  }
app.use(Vue3BaiduMapGL, {
    ak: 'iXCHyg2fa1Nq7qhNB88mJHcRlM8zhjO8',
    plugins: ['TrackAnimation']
})
app.use(createPinia())
app.use(router)
app.use(ElementPlus)

app.mount('#app')