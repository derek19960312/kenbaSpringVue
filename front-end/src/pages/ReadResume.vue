<template>
  <div class="readResume m-3">
    <h1>{{ title }}</h1>
    <IngredientTable :items="ingredients" :tableStyle="1"/>
    <router-link :to="{name:'SiteMap'}">Back</router-link>
  </div>
</template>

<script>
import IngredientTable from '@/components/IngredientTable.vue'

export default {
  name: 'ReadResume',
  data () {
    return {
      title: '食譜總覽',
      ingredients: [{ ingreName: '巧克力', ingreCount: '10', ingreUnit: 'g', ingreTotalPrice: '200' }],
      resume: {
        'resumeName': '123',
        'ingredients': [{
          'ingreName': '巧克力',
          'ingreCount': '10',
          'ingreUnit': 'g',
          'ingreTotalPrice': '200'
        }],
        'resumeAmt': 0}
    }
  },
  components: {
    IngredientTable
  },
  methods: {
    getRecipes () {
      this.axios.get('http://localhost:8080/recipe').then((result) => { console.log(result.data) })
    }
  }
}
</script>

<style scoped>
h1, h2 {
  font-weight: normal;
}
</style>
