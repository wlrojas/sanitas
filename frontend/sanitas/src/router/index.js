import { createRouter, createWebHistory } from 'vue-router'
import Inicio from '@/views/Inicio.vue'
import IniciarSesion from '@/views/IniciarSesion.vue'
import Registro from '@/views/Registro.vue'
import Busqueda from '@/views/Busqueda.vue'
import Perfil from '@/views/Perfil.vue'
import MenuPrincipal from '@/views/MenuPrincipal.vue'
import DocumentosMedicos from '@/views/HistorialMedico.vue'
import RegistroEspecialista from '@/views/RegistroEspecialista.vue'
import CitasPaciente from "@/views/CitasPaciente.vue";
import HistorialMedico from "@/views/HistorialMedico.vue";
import Disponibilidad from "@/views/Disponibilidad.vue";
import CitasEspecialista from "@/views/CitasEspecialista.vue";

const routes = [
    { path: '/', component: Inicio, name: 'Inicio' },
    { path: '/login', component: IniciarSesion, name: 'login' },
    { path: '/registro', component: Registro, name: 'registro' },

    { path: '/busqueda', component: Busqueda, meta: { requiereAuth: true }, name: 'busqueda' },

    {
        path: '/perfil',
        redirect: () => {
            const id = localStorage.getItem('idUsuario')
            return { name: 'perfil', params: { id } }
        }
    },
    {
        path: '/perfil/:id',
        component: Perfil,
        meta: { requiereAuth: true },
        name: 'perfil'
    },

    { path: '/documentos-medicos', component: DocumentosMedicos, meta: { requiereAuth: true }, name: 'documentosMedicos' },
    { path: '/menu', component: MenuPrincipal, meta: { requiereAuth: true }, name: 'menu' },
    { path: '/registro-especialista', component: RegistroEspecialista, meta: { requiereAuth: true }, name: 'registro-especialista' },
    {
        path: '/citas-paciente',
        name: 'CitasPaciente',
        component: CitasPaciente,
        meta: { requiereAuth: true }
    },
    {
        path: '/historial',
        name: 'Historial',
        component: HistorialMedico,
        meta: { requiereAuth: true }
    },
    {
        path: '/disponibilidad',
        name: 'Disponibilidad',
        component: Disponibilidad,
        meta: { requiereAuth: true }
    },
    {
        path: '/citas-especialista',
        name: 'CitasEspecialista',
        component: CitasEspecialista,
        meta: { requiereAuth: true }
    },
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
