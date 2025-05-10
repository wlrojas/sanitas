<template>
  <!-- Hero con fondo y overlay -->
  <v-sheet min-height="100vh" class="hero">
    <v-img src="/assets/health-bg.jpg" class="hero-img" cover></v-img>
    <v-overlay absolute opacity="0.6" color="#000"></v-overlay>

    <!-- Contenedor centrado para el menú -->
    <v-container fluid class="pa-0 d-flex align-center justify-center">
      <v-card elevation="8" class="pa-8 menu-card">
        <v-card-title class="justify-center text-h5 mb-6">
          Menú Principal
        </v-card-title>

        <v-card-text>
          <v-row dense>
            <v-col cols="12" md="6" v-for="item in menuItems" :key="item.title">
              <v-btn block large color="primary" class="menu-btn" @click="item.action">
                <v-icon left>{{ item.icon }}</v-icon>
                {{ item.title }}
              </v-btn>
            </v-col>
            <v-col cols="12">
              <v-btn block large outlined color="secondary" class="menu-btn" @click="logout">
                <v-icon left>mdi-logout</v-icon>
                Cerrar sesión
              </v-btn>
            </v-col>
          </v-row>
        </v-card-text>
      </v-card>
    </v-container>
  </v-sheet>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const rol = ref(localStorage.getItem('rol') || '')

function irPerfil() {
  const id = localStorage.getItem('idUsuario')
  router.push({ name: 'perfil', params: { id } })
}

function logout() {
  localStorage.removeItem('token')
  localStorage.removeItem('rol')
  localStorage.removeItem('idUsuario')
  router.push({ name: 'Inicio' })
}

const menuItems = ref([])
if (rol.value === 'paciente') {
  menuItems.value = [
    { title: 'Mi perfil', icon: 'mdi-account-circle', action: irPerfil },
    { title: 'Buscar especialistas', icon: 'mdi-magnify', action: () => router.push({ name: 'busqueda' }) },
    { title: 'Mis citas', icon: 'mdi-calendar-check', action: () => router.push({ name: 'CitasPaciente' }) },
    { title: 'Mi historial médico', icon: 'mdi-file-document-outline', action: () => router.push({ name: 'Historial' }) },
  ]
} else if (rol.value === 'especialista') {
  menuItems.value = [
    { title: 'Mi perfil', icon: 'mdi-account-circle', action: irPerfil },
    { title: 'Mi disponibilidad', icon: 'mdi-calendar-range', action: () => router.push({ name: 'Disponibilidad' }) },
    { title: 'Citas agendadas', icon: 'mdi-calendar-multiple-check', action: () => router.push({ name: 'CitasEspecialista' }) },
    { title: 'Pacientes & historial', icon: 'mdi-folder-account', action: () => router.push({ name: 'Pacientes' }) },
  ]
}
</script>

<style scoped>
.hero {
  position: relative;
  overflow-y: auto;
}
.hero-img {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -2;
}
.menu-card {
  width: 90vw;
  max-width: 800px;
  border-radius: 1.5rem;
}
.menu-btn {
  margin-bottom: 16px;
}
.pa-0 {
  padding: 0;
}
.mb-6 {
  margin-bottom: 24px;
}
</style>