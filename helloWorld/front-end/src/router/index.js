import Vue from 'vue'
import Router from 'vue-router'
import SiteMap from '@/components/SiteMap'
import InsertResume from '@/components/InsertResume'
import ReadResume from '@/components/ReadResume'

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
