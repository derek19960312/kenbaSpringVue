import Vue from 'vue'
import Router from 'vue-router'
import SiteMap from '@/pages/SiteMap'
import InsertRecipe from '@/pages/InsertRecipe'
import ReadRecipe from '@/pages/ReadRecipe'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'SiteMap',
      component: SiteMap
    },
    {
      path: '/InsertRecipe',
      name: 'InsertRecipe',
      component: InsertRecipe
    },
    {
      path: '/ReadRecipe',
      name: 'ReadRecipe',
      component: ReadRecipe
    }
  ]
})
