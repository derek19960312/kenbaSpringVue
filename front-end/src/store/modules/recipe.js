
import axios from 'axios'

// initial state
const state = {
  recipes: []
}

// getters
const getters = {
  recipes: state => state.recipes
}

// actions
const actions = {
  getRecipes ({ commit }) {
    axios.get('http://localhost:8080/recipe').then((res) => {
      console.log(res)
      commit('setRecipes', res.data)
    })
  }
}

// mutations
const mutations = {
  setRecipes (state, recipes) {
    state.recipes = recipes
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
