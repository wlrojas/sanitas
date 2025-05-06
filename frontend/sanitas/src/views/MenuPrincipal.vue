<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

// Lee rol e idUsuario del storage
const rol = ref(localStorage.getItem('rol') || '')
const irPerfil = () => {
  const id = localStorage.getItem('idUsuario')
  router.push({ name: 'perfil', params: { id } })
}
const router = useRouter()

function logout() {
  localStorage.removeItem('token')
  localStorage.removeItem('rol')
  localStorage.removeItem('idUsuario')
  router.push({ name: 'Inicio' })
}
</script>

<template>
  <v-container class="fill-height pa-8" fluid>
    <v-row class="fill-height d-flex align-center justify-center">
      <v-col cols="12" md="8" lg="6">
        <v-card elevation="6" class="pa-8">
          <v-card-title class="justify-center text-h5 mb-4">
            Menú Principal
          </v-card-title>
          <v-card-text>
            <v-row dense>
              <!-- Opción común: Mi perfil -->
              <v-col cols="12">
                <v-btn block color="primary" class="ma-2" @click="irPerfil">
                  Mi perfil
                </v-btn>
              </v-col>

              <!-- Opciones para paciente -->
              <template v-if="rol === 'paciente'">
                <v-col cols="12">
                  <v-btn block color="primary" class="ma-2" @click="router.push({ name: 'busqueda' })">
                    Buscar especialistas
                  </v-btn>
                </v-col>
                <v-col cols="12">
                  <v-btn block color="primary" class="ma-2" @click="router.push({ name: 'CitasPaciente' })">
                    Mis citas
                  </v-btn>
                </v-col>
                <v-col cols="12">
                  <v-btn block color="primary" class="ma-2" @click="router.push({ name: 'Historial' })">
                    Mi historial médico
                  </v-btn>
                </v-col>
              </template>

              <!-- Opciones para especialista -->
              <template v-else-if="rol === 'especialista'">
                <v-col cols="12">
                  <v-btn block color="primary" class="ma-2" @click="router.push({ name: 'Disponibilidad' })">
                    Mi disponibilidad
                  </v-btn>
                </v-col>
                <v-col cols="12">
                  <v-btn block color="primary" class="ma-2" @click="router.push({ name: 'CitasEspecialista' })">
                    Citas agendadas
                  </v-btn>
                </v-col>
                <v-col cols="12">
                  <v-btn block color="primary" class="ma-2" @click="router.push({ name: 'Pacientes' })">
                    Pacientes & historial
                  </v-btn>
                </v-col>
              </template>

              <!-- Cerrar sesión -->
              <v-col cols="12">
                <v-btn block color="secondary" class="ma-2" @click="logout">
                  Cerrar sesión
                </v-btn>
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<style scoped>
.fill-height {
  height: 100vh;
}
</style>
