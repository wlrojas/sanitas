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
    // Enviar credenciales y obtener solo el token
    const response = await authService.login({email: email.value, password: password.value})
    const token = response.token

    // Decodificar payload del JWT para extraer rol e idUsuario
    const payload = jwtDecode(token)
    const {rol, sub} = payload

    // Guardar en localStorage para uso futuro
    localStorage.setItem('token', token)
    localStorage.setItem('rol', rol)
    localStorage.setItem('idUsuario', sub)
    console.log(token, rol, sub)

    // Configurar header Authorization para próximas peticiones
    api.defaults.headers.common['Authorization'] = `Bearer ${token}`

    // Redirigir según rol extraído
    if (rol === 'especialista') {
      await router.push({name: 'Perfil', params: {id: sub}})
    } else {
      await router.push({name: 'Buscar'})
    }
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