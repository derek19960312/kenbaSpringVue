<template>
    <b-container class='my-3'>
      <b-card>
        <b-form>
          <b-form-row>
            <b-form-group
              label-cols='auto'
              label="名稱："
              :label-for=nameId
            >
              <b-form-input :id=nameId :plaintext=!editing :disabled=!editing v-model='recipeLocal.name' type="text"/>
            </b-form-group>
            <b-col v-if='type == "get"' class='text-right'>
              <b-button variant="primary" @click="onUpdateSwitch" v-if='!editing'>編輯</b-button>
              <b-button variant="primary" @click="onUpdateSwitch" v-else >完成</b-button>
              <b-button variant="danger" @click="deleteRecipe(recipeLocal.id)">刪除</b-button>
            </b-col>
          </b-form-row>
          <div class="m-2">
            <b-form-row class='border-bottom my-2' v-for='(recipe, index) in recipeLocal.reciepIngredients' :key='index'>
              <b-input-group>
                <b-form-input :plaintext=!editing :disabled=!editing v-model='recipe.ingredient.name' type="text"/>
                <b-form-input :plaintext=!editing :disabled=!editing v-model='recipe.riCount' type="number" @keyup.stop="coculatePrice"/>
                <b-form-input :plaintext=!editing :disabled=!editing v-model='recipe.ingredient.unit' type="text"/>
                <b-form-input :plaintext=!editing :disabled=!editing v-model='recipe.riPrice' type="number"/>
              </b-input-group>
            </b-form-row>
            <b-avatar v-if=editing class="mx-auto mt-3" text="+" button v-on:click="onIngredientAdd" variant="primary"/>
            <b-form-row class='text-right mt-4'>
              <b-col></b-col>
              <b-col></b-col>
              <b-col>成本：</b-col>
              <b-col>{{totalPrice}}</b-col>
            </b-form-row>
          </div>
        </b-form>
      </b-card>
    </b-container>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  data () {
    return {
      fields: [
        'name',
        'count',
        'price'
      ],
      nameId: 'input-recipe-name' + this.recipe.id,
      editing: false,
      recipeLocal: this.cloneDeep(this.recipe),
      totalPrice: 0
    }
  },
  props: ['recipe', 'type'],
  methods: {
    ...mapActions('recipe', ['deleteRecipe', 'updateRecipe']),
    onRecipeUpdate (field, value) {
      this.$store.commit('updateRecipeData', field, value, this.recipe.id)
    },
    onUpdateSwitch (event) {
      this.editing = !this.editing
      if (!this.editing) {
        this.updateRecipe(this.recipeLocal)
      }
    },
    onIngredientAdd (event) {
      this.recipeLocal.reciepIngredients.push(
        {
          id: '',
          riCount: '',
          riPrice: '',
          ingredient: {
            id: '',
            name: '',
            unit: ''
          }
        }
      )
    },
    coculatePrice () {
      var total = 0
      this.recipeLocal.reciepIngredients.forEach(ri => {
        total += parseInt(ri.riPrice)
      })
      this.totalPrice = total
    }
  },
  mounted () {
    this.coculatePrice()
    this.editing = this.type === 'add'
  }
}
</script>

<style>
  .boder_bottom {
    border-bottom: 1px gray dotted
  }
</style>
