<template>
    <div>
        <br/>{{ detailId }}的细节展示与评论区页面TODO
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const article = ref({})
let detailId = ref()
onMounted(() => {
  detailId.value = route.params.siteName
})

  </script>
  
  <style>
  </style>
  