<template>
  <div class="readRecipe m-3">
    <h1>{{ title }}</h1>
    <RecipeInfo v-for='recipe in recipes' :key='recipe.id' :recipe='recipe'/>
    <router-link :to="{name:'SiteMap'}">Back</router-link>
  </div>
</template>

<script>
import RecipeInfo from '@/components/RecipeInfo.vue'
import { mapGetters, mapActions } from 'vuex'

export default {
  data () {
    return {
      title: '食譜總覽'
    }
  },
  name: 'ReadRecipe',
  computed: {
    ...mapGetters('recipe', ['recipes'])
  },
  components: {
    RecipeInfo
  },
  methods: {
    ...mapActions('recipe', ['getRecipes'])
  },
  mounted () {
    this.getRecipes()
  }
}
</script>

<style scoped>
h1, h2 {
  font-weight: normal;
}
</style>
