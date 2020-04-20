import axios from 'axios'

const baseURL = 'http://localhost:8080/'

const api = axios.create({
  baseURL: baseURL,
  headers: { 'Content-Type': 'application/json' }
})

api.interceptors.request.use(
  async request => {
    return request
  },
  error => {
    return Promise.reject(error)
  }
)
api.interceptors.response.use(
  async response => {
    console.log(response)
    return Promise.resolve(response.data)
  },
  error => {
    return Promise.reject(error)
  }
)

export default api
