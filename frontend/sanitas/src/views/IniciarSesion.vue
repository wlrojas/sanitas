<template>
  <!-- Hero con fondo y overlay -->
  <v-sheet min-height="100vh" class="hero">
    <v-img src="/assets/health-bg.jpg" class="hero-img" cover></v-img>
    <v-overlay absolute opacity="0.6" color="#000"></v-overlay>

    <!-- Contenedor centrado para el formulario -->
    <v-container fluid class="pa-0 d-flex align-center justify-center">
      <v-card elevation="8" class="pa-8 registration-card">
        <v-card-title class="justify-center text-h5 mb-6">
          Iniciar sesión
        </v-card-title>

        <v-card-text>
          <v-alert v-if="error" type="error" dense class="mb-4">
            {{ error }}
          </v-alert>

          <v-form @submit.prevent="onSubmit">
            <v-row dense>
              <v-col cols="12">
                <v-text-field
                    v-model="email"
                    label="Correo electrónico"
                    type="email"
                    required
                    outlined
                />
              </v-col>
              <v-col cols="12">
                <v-text-field
                    v-model="password"
                    label="Contraseña"
                    type="password"
                    required
                    outlined
                />
              </v-col>
            </v-row>
          </v-form>
        </v-card-text>

        <v-card-actions class="d-flex justify-center mt-6">
          <v-btn
              type="submit"
              color="primary"
              large
              :loading="loading"
              @click="onSubmit"
          >
            Iniciar sesión
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-container>
  </v-sheet>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import authService from '@/services/serviceAuth.js'
import api from '@/plugins/axios.js'
import { jwtDecode } from 'jwt-decode'

const email = ref('')
const password = ref('')
const error = ref(null)
const loading = ref(false)
const router = useRouter()

async function onSubmit() {
  error.value = null
  loading.value = true
  try {
    const response = await authService.login({ email: email.value, password: password.value })
    const token = response.token
    const { rol, sub } = jwtDecode(token)

    localStorage.setItem('token', token)
    localStorage.setItem('rol', rol)
    localStorage.setItem('idUsuario', sub)
    api.defaults.headers.common['Authorization'] = `Bearer ${token}`

    await router.push({ name: 'menu', params: { id: sub } })
  } catch (e) {
    console.error(e)
    error.value = 'Correo o contraseña incorrectos.'
  } finally {
    loading.value = false
  }
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
.registration-card {
  width: 90vw;
  max-width: 600px;
  border-radius: 1.5rem;
}
.pa-0 {
  padding: 0;
}
.mb-4 {
  margin-bottom: 16px;
}
.mt-6 {
  margin-top: 24px;
}
</style>