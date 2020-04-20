
import api from '@/api'
// import axios from 'axios'

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
    api.get('/recipe').then((res) => {
      commit('setRecipes', res)
    })
  },
  getRecipe ({ commit }, id) {
    api.get('/recipe/' + id).then((res) => {
      commit('setRecipes', res)
    })
  },
  createRecipe ({ commit }, recipe) {
    api.post('/recipe', recipe).then((res) => {
      commit('setRecipes', res)
    })
  },
  updateRecipe ({ commit, dispatch }, recipe) {
    api.put('/recipe/' + recipe.id, recipe).then((res) => {
      dispatch('getRecipes')
    })
  },
  deleteRecipe ({ commit, dispatch }, id) {
    api.delete('/recipe/' + id).then((res) => {
      dispatch('getRecipes')
    })
  }
}

// mutations
const mutations = {
  setRecipes (state, recipes) {
    state.recipes = recipes
  }
  // updateRecipeData (state, field, value, id) {
  //   Object.assign(state.recipes.find(recipe => recipe.id === id), {
  //     [field]: value
  //   })
  // }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
