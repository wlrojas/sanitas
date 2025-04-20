import api from '@/plugins/axios.js'

export default {
    async buscar(texto) {
        console.log('[servicioEspecialistas] haciendo GET /especialistas/all?filtro=', texto)
        const resp = await api.get('/especialistas/all', {
            params: { filtro: texto }
        });
        console.log(resp.data);
        return resp.data;
    }
};