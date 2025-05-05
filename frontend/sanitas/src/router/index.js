import { createRouter, createWebHistory } from 'vue-router'
import Inicio from "../views/Inicio.vue";
import IniciarSesion from '../views/IniciarSesion.vue'
import Registro from '../views/Registro.vue'
import Busqueda from '../views/Busqueda.vue'
import Perfil from '../views/Perfil.vue'
import MenuPrincipal from '@/views/MenuPrincipal.vue';
import DocumentosMedicos from '@/views/DocumentosMedicos.vue';
import RegistroEspecialista from '@/views/RegistroEspecialista.vue';

const routes = [
    { path: '/', component: Inicio, name: 'Inicio' },
    { path: '/login', component: IniciarSesion, name: 'login' },
    { path: '/registro', component: Registro },
    { path: '/busqueda', component: Busqueda, meta: {requiereAuth: true} },
    { path: '/perfil', component: Perfil, meta: {requiereAuth: true} },
    { path: '/documentos-medicos', component: DocumentosMedicos, meta: {requiereAuth: true} },
    { path: '/perfil/:id', component: Perfil, meta: { requiereAuth: true } },
    { path: '/menu', component: MenuPrincipal, meta: { requiereAuth: true } },
    { path: '/registro-especialista', component: RegistroEspecialista, meta: { requiereAuth: true } },
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

router.beforeEach((to, from, next) => {
    const token = localStorage.getItem('token')
    if (to.meta.requiereAuth && !token) {
        return next({ name: 'login' })
    }
    next()
})

export default router