import Vue from 'vue'
import Vuex from 'vuex'
import recipe from './modules/recipe'

Vue.use(Vuex)

const debug = process.env.NODE_ENV !== 'production'

export default new Vuex.Store({
  modules: {
    recipe
  },
  strict: debug,
  plugins: []
})
