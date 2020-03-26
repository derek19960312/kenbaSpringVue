<template>
  <div class="insertResume">
    <h1>{{ title }}</h1>
    <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
        id="input-group-1"
        label="Resume name:"
        label-for="resumeName"
        description="請輸入食譜名稱"
     >
        <b-form-input
          id="resumeName"
          v-model="form.resumeName"
          type="text"
          required
          placeholder="請輸入食譜名稱"
        ></b-form-input>
      </b-form-group>

      <b-card class="mt-3 mv-2" header="食材們">
        <b-list-group flush>
          <b-list-group-item v-for="ingredient in form.ingredientList" :key="ingredient.name">
            {{ ingredient.name }}
          </b-list-group-item>
        </b-list-group>
        <b-avatar icon="plus" button v-on:click="onIngredientAdd" variant="primary"/>
      </b-card>

      <b-button type="submit" variant="primary">送出</b-button>
      <b-button type="reset" variant="danger">清除</b-button>
    </b-form>

  </div>
    <router-link :to="{name:'SiteMap'}">返回</router-link>
  </div>
</template>

<script>
export default {
  name: 'InsertResume',
  data () {
    return {
      title: '新增食譜',
      form: {
        resumeName: '',
        ingredientList: [{name: '123'}, {name: '456'}]
        // amt: 0
      },
      show: true
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
      this.form.amt = 0
      this.form.ingredientList = []
      // Trick to reset/clear native browser form validation state
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    },
    onIngredientAdd (evt) {
      this.form.ingredientList.push({name: '1'})
    }
  }
  // components: {
  //   ingredient: {
  //     template: '<p>This is home.<p>'
  //   }
  // }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
</style>
