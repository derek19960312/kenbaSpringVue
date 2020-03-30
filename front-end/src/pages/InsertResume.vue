<template>
  <div class="insertResume my-3">
    <h1>{{ title }}</h1>
    <b-form class="m-3" @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
        id="input-group-1"
        label="食譜名稱："
        label-cols="4"
        label-cols-lg="2"
        label-for="resumeName">
        <b-form-input
          id="resumeName"
          v-model="form.resumeName"
          type="text"
          required
          placeholder="請輸入食譜名稱"/>
      </b-form-group>

      <b-card class="my-3" header="食材們" no-body>
        <ingredientTable :items="form.ingredients"/>
        <b-avatar class="mx-auto mb-3" text="+" button v-on:click="onIngredientAdd" variant="primary"/>
      </b-card>

      <h2>{{ form.resumeAmt }}</h2>

      <b-button type="submit" variant="primary">送出</b-button>
      <b-button type="reset" variant="danger">清除</b-button>
    </b-form>
    <router-link :to="{name:'SiteMap'}">返回</router-link>

    <b-modal
      id="insertIngredient"
      centered
      title="新增食材"
      @show="resetInsertIngredientModal"
      @hidden="resetInsertIngredientModal"
      @ok="handleInsertIngredientOk"
    >
      <form @submit.stop.prevent="handleInsertIngredientSubmit">
        <b-form-group
          label="名稱"
          label-for="ingreName"
          invalid-feedback="請輸入名稱"
        >
          <b-form-input
            id="ingreName"
            v-model="insertIngreForm.ingreName"
            required
          ></b-form-input>
        </b-form-group>
        <b-form-group
          label="數量"
          label-for="ingreCount"
          invalid-feedback="請輸入數量"
        >
          <b-form-input
            id="ingreCount"
            v-model="insertIngreForm.ingreCount"
            required
          ></b-form-input>
        </b-form-group>
        <b-form-group
          label="單位"
          label-for="ingreUnit"
          invalid-feedback="請輸入單位"
        >
          <b-form-select
            id="ingreUnit"
            v-model="insertIngreForm.ingreUnit"
            :options="insertFormOpts"
          ></b-form-select>
        </b-form-group>
        <b-form-group
          label="總價"
          label-for="ingreTotalPrice"
          invalid-feedback="請輸入總價"
        >
          <b-form-input
            id="ingreTotalPrice"
            v-model="insertIngreForm.ingreTotalPrice"
            required
          ></b-form-input>
        </b-form-group>
      </form>
    </b-modal>
  </div>
</template>

<script>
import IngredientTable from '@/components/IngredientTable.vue'

export default {
  name: 'InsertResume',
  data () {
    return {
      title: '新增食譜',
      form: {
        resumeName: '',
        ingredients: [{ ingreName: '巧克力', ingreCount: '10', ingreUnit: 'g', ingreTotalPrice: '200' }],
        resumeAmt: 0
      },
      insertIngreForm: {
        ingreName: '',
        ingreCount: '',
        ingreUnit: '',
        ingreTotalPrice: ''
      },
      insertFormOpts: [
        { value: '', text: '請選擇' },
        { value: '克', text: '克' },
        { value: '個', text: '個' } // each
      ],
      show: true,
      ingredient: { ingreName: '', ingreCount: '', ingreUnit: '', ingreTotalPrice: '' }
    }
  },
  methods: {
    onSubmit (evt) {
      evt.preventDefault()
      alert(JSON.stringify(this.form))
    },
    onReset (evt) {
      evt.preventDefault()
      // Reset our form values
      this.form.resumeName = ''
      this.form.resumeAmt = 0
      this.form.ingredients = []
      // Trick to reset/clear native browser form validation state
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    },
    onIngredientAdd (evt) {
      this.$bvModal.show('insertIngredient')
    },
    resetInsertIngredientModal () {
      this.insertIngreForm.ingreName = ''
      this.insertIngreForm.ingreCount = ''
      this.insertIngreForm.ingreUnit = ''
      this.insertIngreForm.ingreTotalPrice = ''
    },
    handleInsertIngredientOk (bvModalEvt) {
      bvModalEvt.preventDefault()
      this.handleInsertIngredientSubmit()
    },
    handleInsertIngredientSubmit () {
      var ingre = {
        ingreName: this.insertIngreForm.ingreName,
        ingreCount: this.insertIngreForm.ingreCount,
        ingreUnit: this.insertIngreForm.ingreUnit,
        ingreTotalPrice: this.insertIngreForm.ingreTotalPrice }
      if (this.validation(ingre)) {
        this.form.ingredients.push(ingre)
        this.countTotalAmt()
        this.resetInsertIngredientModal()
        this.$nextTick(() => {
          this.$bvModal.hide('insertIngredient')
        })
      }
    },
    countTotalAmt () {
      var total = 0
      this.form.ingredients.forEach(function (item, index, array) {
        total += Number(item.ingreTotalPrice)
      })
      console.log('total' + total)
      this.form.resumeAmt = total
    },
    validation (ingre) {
      return true
    }
  },
  components: {
    IngredientTable
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
</style>
