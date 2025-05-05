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
    }
}
