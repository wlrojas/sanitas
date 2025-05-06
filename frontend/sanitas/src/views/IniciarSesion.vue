<template>
  <v-container class="fill-height d-flex align-center justify-center" fluid>
    <v-card width="400" elevation="4" class="pa-6">
      <v-card-title class="justify-center text-h5">
        Iniciar sesión
      </v-card-title>
      <v-card-text>
        <v-form @submit.prevent="onSubmit">
          <!-- Mostrar error en login -->
          <v-alert v-if="error" type="error" dense text class="mb-4">
            {{ error }}
          </v-alert>

          <v-text-field
              v-model="email"
              label="Correo electrónico"
              type="email"
              required
              outlined
          />

          <v-text-field
              v-model="password"
              label="Contraseña"
              type="password"
              required
              outlined
          />

          <v-btn
              type="submit"
              color="primary"
              class="mt-4"
              block
              :loading="loading"
          >
            Iniciar sesión
          </v-btn>
        </v-form>
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script setup>
import {ref} from 'vue'
import {useRouter} from 'vue-router'
import authService from '@/services/serviceAuth.js'
import api from '@/plugins/axios.js'
import {jwtDecode} from 'jwt-decode'

const email = ref('')
const password = ref('')
const error = ref(null)
const loading = ref(false)
const router = useRouter()

async function onSubmit() {
  error.value = null
  loading.value = true
  try {
    const response = await authService.login({email: email.value, password: password.value})
    const token = response.token

    const payload = jwtDecode(token)
    const {rol, sub} = payload

    localStorage.setItem('token', token)
    localStorage.setItem('rol', rol)
    localStorage.setItem('idUsuario', sub)

    api.defaults.headers.common['Authorization'] = `Bearer ${token}`

    await router.push({name: 'menu', params: {id: sub}})

  } catch (e) {
    console.log(e)
    error.value = 'Correo o contraseña incorrectos.'
  } finally {
    loading.value = false
  }
}
</script>

<style scoped>
.fill-height {
  height: 100vh;
}

.mb-4 {
  margin-bottom: 16px;
}
</style>