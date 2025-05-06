import api from '@/plugins/axios'

export default {
    // Trae el historial de un paciente
    async getHistorial(idPaciente) {
        const resp = await api.get(`/historial/${idPaciente}`)
        return resp.data  // { id, idPaciente, resumen, examenes: [ { nombre, resultado, fecha } ] }
    },
    // Guarda un historial nuevo
    async saveHistorial(payload) {
        const resp = await api.post('/historial/save', payload)
        return resp.data
    },
    // Actualiza un historial existente
    async updateHistorial(idPaciente, payload) {
        const resp = await api.put(`/historial/${idPaciente}/actualizar`, payload)
        return resp.data
    }
}
