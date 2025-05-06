// src/services/servicioCitas.js
import api from '@/plugins/axios'

export default {
    // Obtiene todas las citas de un paciente; opcionalmente filtra por status
    async getCitasPaciente(idPaciente, status) {
        const params = { id: idPaciente }
        if (status && status !== 'todas') params.status = status
        const resp = await api.get('/citas/all/paciente', { params })
        return resp.data    // Array de citas { id, idEspecialista, idPaciente, fecha, hora, status }
    },

    // (Más adelante, similar para especialista)
    async getCitasEspecialista(idEspecialista, status) {
        const params = { id: idEspecialista }
        if (status && status !== 'todas') params.status = status
        const resp = await api.get('/citas/all/especialista', { params })
        return resp.data
    }
}
