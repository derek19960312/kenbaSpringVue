import Vue from 'vue'
import Router from 'vue-router'
import SiteMap from '@/pages/SiteMap'
import InsertResume from '@/pages/InsertResume'
import ReadResume from '@/pages/ReadResume'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'SiteMap',
      component: SiteMap
    },
    {
      path: '/InsertResume',
      name: 'InsertResume',
      component: InsertResume
    },
    {
      path: '/ReadResume',
      name: 'ReadResume',
      component: ReadResume
    }
  ]
})
