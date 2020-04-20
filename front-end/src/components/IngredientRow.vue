<template>
  <b-container>
    <b-row>
      <b-col>{{ri.ingredient.name}}</b-col>
      <b-col>{{ri.riCount}} {{ri.ingredient.unit}}</b-col>
      <b-col>價錢： ${{ri.riPrice}}</b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  name: 'IngredientRow',
  props: ['ri']
}
</script>

<style scoped>
 .b-container {
    border-bottom: 3px gray
 }
</style>
