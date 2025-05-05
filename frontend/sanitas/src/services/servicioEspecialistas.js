import api from '@/plugins/axios.js'

export default {
    async buscar(texto) {
        console.log('[servicioEspecialistas] haciendo GET /especialistas/all?filtro=', texto)
        const resp = await api.get('/especialistas/all', {
            params: { filtro: texto }
        });
        console.log(resp.data);
        return resp.data;
    },

    /**
     * Guarda un nuevo especialista (y su usuario asociado)
     * @param {{ datosUsuario: { nombre: string, password: string, rol: string, email: string, telefono: number }, datosEspecialista: { especialidad: string, descripcion: string } }} payload
     * @returns {Promise<Object>} datos del especialista creado
     */
    async save(payload) {
        console.log('[especialistaService] POST /especialistas/save', payload)
        return api.post('/especialistas/save', payload)
            .then(res => res.data)
    }
};