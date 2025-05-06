import api from '@/plugins/axios'
import servicioEspecialistas from '@/services/servicioEspecialistas'

export default {
    // Llama al endpoint original con el idEspecialista
    async getDisponibilidad(idEspecialista) {
        const resp = await api.get(`/especialistas/${idEspecialista}/disponibilidad`)
        return resp.data
    },

    // Nuevo: a partir del idUsuario, busca tu especialista y devuelve su disponibilidad
    async getDisponibilidadPorUsuario(idUsuario) {
        // 1) Traer todos los especialistas
        const lista = await servicioEspecialistas.buscar('')
        // 2) Encontrar el que corresponde a este usuario
        const esp = lista.find(e => e.idUsuario === idUsuario)
        if (!esp) {
            throw new Error('No existe un especialista registrado con este usuario')
        }
        // 3) Devolver la disponibilidad real
        return this.getDisponibilidad(esp.idEspecialista)
    }
}
