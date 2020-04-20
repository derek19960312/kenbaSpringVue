<template>
  <div class="readRecipe m-3">
    <h1>{{ title }}</h1>
    <RecipeInfo v-for='recipe in recipes' :key='recipe.id' :recipe='recipe' type='get'/>
    <b-button :to="{name:'SiteMap'}">返回</b-button>
    <div class="mb-5 mr-5 fixed-bottom d-flex flex-row-reverse">
      <b-avatar text="+" button v-on:click="onRecipeAdd" variant="primary"/>
    </div>
    <b-modal
      id="addRecipe"
      centered
      title="新增食譜"
      @show="resetAddRecipeModal"
      @hidden="resetAddRecipeModal"
      @ok="handleAddRecipeOk"
    >
      <RecipeInfo :recipe='newAddRecipeModal' type='add'/>
    </b-modal>
  </div>
</template>

<script>
import RecipeInfo from '@/components/RecipeInfo.vue'
import { mapGetters, mapActions } from 'vuex'

export default {
  data () {
    return {
      title: '食譜總覽',
      newAddRecipeModal: {
        id: '',
        name: '',
        count: '',
        reciepIngredients: []
      }
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
    ...mapActions('recipe', ['getRecipes', 'createRecipe']),
    onRecipeAdd () {
      this.$bvModal.show('addRecipe')
    },
    resetAddRecipeModal () {
      this.newAddRecipeModal = {
        id: '',
        name: '',
        count: '',
        reciepIngredients: []
      }
    },
    handleAddRecipeOk () {
      this.createRecipe(this.newAddRecipeModal)
    }
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
