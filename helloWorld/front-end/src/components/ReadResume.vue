<template>
  <div class="readResume">
    <h1>{{ msg }}</h1>
    <h2>Essential Links</h2>
    <router-link :to="{name:'SiteMap'}">Back</router-link>
  </div>
</template>

<script>
export default {
  name: 'ReadResume',
  data () {
    return {
      msg: 'This is read resume'
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
