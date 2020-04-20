<template>
  <div class="sitemap">
      <b-img src='../assets/logo.jpg' fluid/>
      <!-- <div class='w-100'></div>
      <div class='mt-3 mb-3'>
          <b-button :to="{name:'InsertRecipe'}">InsertResume</b-button>
          <b-button :to="{name:'ReadRecipe'}">ReadResume</b-button>
      </div> -->
  </div>
</template>

<script>
export default {
  name: 'SiteMap',
  data () {
    return {
      name: 'KenBa Kitchen'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
</style>
