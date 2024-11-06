import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'map',
      component: () => import('../views/Map.vue')
    },
    {
      path: '/sq',
      name: 'sq',
      component: () => import('../views/Sq.vue')
    },
    {
      path: '/user',
      name: 'user',
      component: () => import('../views/User.vue')
    },
    {
      path: '/pub',
      name: 'pub',
      component: () => import('../views/childviews/Crea.vue')
    },
    {
      path: '/our',
      name: 'our',
      component: () => import('../views/childviews/Our.vue')
    }
  ]
})

export default router
