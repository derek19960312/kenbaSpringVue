<template>
    <div>
        <h2>{{recipe.name}}</h2>
        <h2>{{recipe.count}}</h2>
        <IngredientTable :items="recipe.reciepIngredients" :tableStyle="1"/>
    </div>
</template>

<script>
import IngredientTable from '@/components/IngredientTable.vue'

export default {
  props: ['recipe'],
  components: {
    IngredientTable
  }
}
</script>

<style>

</style>
