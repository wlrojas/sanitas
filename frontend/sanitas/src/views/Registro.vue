<template>
  <v-container class="fill-height pa-8" fluid>
    <v-row class="d-flex align-center justify-center fill-height">
      <v-col cols="12" md="8" lg="6">
        <v-form @submit.prevent="onSubmit" ref="form">
          <v-card elevation="4" class="pa-8">
            <v-card-title class="justify-center text-h5 mb-4">
              Registro de Cuenta
            </v-card-title>

            <v-card-text>
              <v-alert v-if="error" type="error" dense class="mb-4">
                {{ error }}
              </v-alert>

              <v-row dense>
                <!-- Selección de rol -->
                <v-col cols="12">
                  <v-select
                      v-model="rol"
                      label="Tipo de usuario"
                      :items="['Paciente', 'Especialista']"
                      required
                      outlined
                  />
                </v-col>

                <!-- Campos comunes -->
                <v-col cols="12">
                  <v-text-field
                      v-model="name"
                      label="Nombre completo"
                      required
                      outlined
                  />
                </v-col>

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
                      v-model="phone"
                      label="Teléfono (+56 9...)"
                      type="tel"
                      required
                      outlined
                  />
                </v-col>

                <!-- Campos de especialista -->
                <template v-if="rol === 'Especialista'">
                  <v-col cols="12">
                    <v-text-field
                        v-model="especialidad"
                        label="Especialidad"
                        required
                        outlined
                    />
                  </v-col>
                  <v-col cols="12">
                    <v-text-field
                        v-model="descripcion"
                        label="Descripción"
                        required
                        outlined
                    />
                  </v-col>
                </template>

                <!-- Contraseñas -->
                <v-col cols="12">
                  <v-text-field
                      v-model="password"
                      label="Contraseña"
                      type="password"
                      required
                      outlined
                  />
                </v-col>
                <v-col cols="12">
                  <v-text-field
                      v-model="passwordVerify"
                      label="Repetir contraseña"
                      type="password"
                      required
                      outlined
                  />
                </v-col>
              </v-row>
            </v-card-text>

            <v-card-actions class="d-flex justify-center">
              <v-btn
                  type="submit"
                  color="primary"
                  :loading="loading"
                  class="ma-2"
              >
                Registrarse
              </v-btn>
              <v-btn
                  text
                  color="secondary"
                  class="ma-2"
                  @click="$router.push({ name: 'Inicio' })"
              >
                Volver
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-form>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import usuariosService from '@/services/servicioUsuario.js'
import especialistaService from '@/services/servicioEspecialistas.js'

const router = useRouter()

// Campos de formulario
const rol = ref('Paciente')
const name = ref('')
const email = ref('')
const phone = ref('')
const especialidad = ref('')
const descripcion = ref('')
const password = ref('')
const passwordVerify = ref('')
const error = ref(null)
const loading = ref(false)

// Validación sencilla
function validate() {
  if (!name.value || !email.value || !phone.value || !password.value || !passwordVerify.value) {
    error.value = 'Por favor, completa todos los campos requeridos.'
    return false
  }
  if (password.value !== passwordVerify.value) {
    error.value = 'Las contraseñas no coinciden.'
    return false
  }
  if (rol.value === 'Especialista' && (!especialidad.value || !descripcion.value)) {
    error.value = 'Ingresa especialidad y descripción para especialista.'
    return false
  }
  error.value = null
  return true
}

// Manejador del submit
async function onSubmit() {
  if (!validate()) return
  loading.value = true

  try {
    if (rol.value === 'Especialista') {
      // Registro de especialista
      await especialistaService.save({
        datosUsuario: {
          nombre: name.value,
          password: password.value,
          rol: 'especialista',
          email: email.value,
          telefono: Number(phone.value)
        },
        datosEspecialista: {
          descripcion: descripcion.value,
          especialidad: especialidad.value
        }
      })
    } else {
      // Registro de paciente
      await usuariosService.save({
        nombre: name.value,
        password: password.value,
        rol: 'paciente',
        email: email.value,
        telefono: Number(phone.value)
      })
    }
    // Al éxito, redirigir a login
    await router.push({name: 'login'})
  } catch (e) {
    console.log(e)
    error.value = e.response?.data?.message || 'Error al registrar el usuario.'
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