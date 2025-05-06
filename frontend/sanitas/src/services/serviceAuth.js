import api from '../plugins/axios.js'

export default {
    login({ email, password }) {
        return api.post('/inicio/login', { email, password })
            .then(res => res.data)
    }
}