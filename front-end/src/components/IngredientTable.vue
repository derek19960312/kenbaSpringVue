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
      fields: [{key: 'ingreName', label: '名稱'}, {key: 'ingreCount', label: '數量'}, {key: 'ingreUnit', label: '單位'}, {key: 'ingreTotalPrice', label: '總金額'}]
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
