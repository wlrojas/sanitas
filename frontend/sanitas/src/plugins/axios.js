// src/plugins/axios.js
import axios from 'axios'

const api = axios.create({
    baseURL: 'http://localhost:8080/api',
})

// interceptor para inyectar JWT
//api.interceptors.request.use(config => {
//    const token = localStorage.getItem('token')
//    if (token) config.headers.Authorization = `Bearer ${token}`
//    return config
//})
//
export default api   // ← aquí
