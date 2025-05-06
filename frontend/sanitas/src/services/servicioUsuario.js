// src/services/usuariosService.js
import api from '@/plugins/axios.js'

export default {
    /**
     * Guarda un nuevo usuario (paciente)
     * @param {{ nombre: string, password: string, rol: string, email: string, telefono: number }} usuario
     * @returns {Promise<Object>} respuesta del servidor (datos del usuario creado o mensaje)
     */
    async save(usuario) {
        return api.post('/usuarios/save', usuario)
            .then(res => res.data)
    },

    async getPerfil(id) {
        const resp = await api.get(`/usuarios/${id}`)
        return resp.data
    },

    // Actualizar datos de usuario
    async updatePerfil(id, data) {
        const resp = await api.put(`/usuarios/${id}`, data)
        return resp.data
    }
}
