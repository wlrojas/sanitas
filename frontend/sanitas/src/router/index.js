import { createRouter, createWebHistory } from 'vue-router'
import Inicio from "../views/Inicio.vue";
import IniciarSesion from '../views/IniciarSesion.vue'
import Registro from '../views/Registro.vue'
import Busqueda from '../views/Busqueda.vue'
import Perfil from '../views/Perfil.vue'

const routes = [
    { path: '/', component: Inicio },
    { path: '/login', component: IniciarSesion },
    { path: '/registro', component: Registro },
    { path: '/busqueda', component: Busqueda, meta: {requiereAuth: false} },
    { path: '/pefil/:id', component: Perfil, meta: { requiereAuth: false } },
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

//router.beforeEach((to, from, next) => {
//    const token = localStorage.getItem('token')
//    if (to.meta.requiereAuth && !token) {
//        return next({ name: 'login' })
//    }
//    next()
//})

export default router