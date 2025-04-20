import api from '../plugins/axios.js'

export default {
    login({ mail, password }) {
        return api.post('/usuarios/login', { mail, password })
            .then(res => res.data)
    }
}