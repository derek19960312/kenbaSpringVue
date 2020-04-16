<template>
  <div v-if="isStyle()">
    <b-table bordered :items="items" :fields="fields"/>
  </div>
  <div v-else>
    <b-table borderless :items="items" :fields="fields"/>
  </div>
</template>

<script>
export default {
  name: 'IngredientTable',
  data () {
    return {
      fields: [{key: 'ingredient.name', label: '名稱'}, {key: 'riCount', label: '數量'}, {key: 'ingredient.unit', label: '單位'}, {key: 'riPrice', label: '總金額'}]
    }
  },
  props: ['items', 'tableStyle'],
  methods: {
    isStyle () {
      if (this.tableStyle) {
        return true
      } else {
        return false
      }
    }
  }
}
</script>
