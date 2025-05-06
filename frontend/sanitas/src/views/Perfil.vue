<template>
  <v-container class="fill-height pa-8" fluid>
    <v-row class="d-flex align-center justify-center fill-height">
      <v-col cols="12" md="8" lg="6">
        <v-card elevation="4" class="pa-8">
          <!-- Título con botón atrás -->
          <v-card-title class="d-flex align-center mb-4">
            <v-btn icon @click="goBack">
              <v-icon>mdi-arrow-left</v-icon>
            </v-btn>
            <span class="text-h5 ml-2">Mis datos</span>
          </v-card-title>

          <v-card-text>
            <v-row dense>
              <!-- Nombre completo -->
              <v-col cols="12">
                <label>Nombre completo</label>
                <div v-if="!editMode">
                  <h3>{{ perfil.nombre }}</h3>
                </div>
                <div v-else>
                  <v-text-field
                      v-model="form.nombre"
                      label="Nombre completo"
                      outlined
                      dense
                  />
                </div>
              </v-col>

              <!-- Email -->
              <v-col cols="12">
                <label>Correo electrónico</label>
                <div v-if="!editMode">
                  <h3>{{ perfil.email }}</h3>
                </div>
                <div v-else>
                  <v-text-field
                      v-model="form.email"
                      label="Correo electrónico"
                      type="email"
                      outlined
                      dense
                  />
                </div>
              </v-col>

              <!-- Teléfono -->
              <v-col cols="12">
                <label>Teléfono (+56)</label>
                <div v-if="!editMode">
                  <h3>+56 {{ perfil.telefono }}</h3>
                </div>
                <div v-else>
                  <v-text-field
                      v-model="form.telefono"
                      label="Teléfono (+56)"
                      type="tel"
                      outlined
                      dense
                  />
                </div>
              </v-col>

              <!-- Botones -->
              <v-col cols="12" class="d-flex justify-center">
                <v-btn
                    v-if="!editMode"
                    color="primary"
                    class="ma-2"
                    @click="startEdition"
                >
                  Editar
                </v-btn>

                <div v-else class="d-flex">
                  <v-btn
                      color="success"
                      class="ma-2"
                      @click="saveChanges"
                  >
                    Guardar
                  </v-btn>
                  <v-btn
                      color="error"
                      class="ma-2"
                      @click="cancelEdition"
                  >
                    Cancelar
                  </v-btn>
                </div>
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { reactive, ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import servicioUsuario from '@/services/servicioUsuario'

// Router y parámetro
const route = useRoute()
const router = useRouter()
const usuarioId = route.params.id

// Estado de perfil y formulario
const perfil = reactive({ nombre: '', email: '', telefono: null })
const form   = reactive({ nombre: '', email: '', telefono: null })
const editMode = ref(false)

// Función para volver atrás
function goBack() {
  router.back()
}

// Carga datos desde el backend
async function loadPerfil() {
  try {
    const data = await servicioUsuario.getPerfil(usuarioId)
    perfil.nombre   = data.nombre
    perfil.email    = data.email
    perfil.telefono = data.telefono
  } catch (e) {
    console.error('Error al cargar perfil:', e)
  }
}

// Entrar en modo edición
function startEdition() {
  form.nombre   = perfil.nombre
  form.email    = perfil.email
  form.telefono = perfil.telefono
  editMode.value = true
}

// Cancelar edición
function cancelEdition() {
  editMode.value = false
}

// Guardar cambios y recargar perfil
async function saveChanges() {
  try {
    const payload = {
      nombre: form.nombre,
      email: form.email,
      telefono: form.telefono
    }
    await servicioUsuario.updatePerfil(usuarioId, payload)
    // Recarga datos actualizados
    await loadPerfil()
    editMode.value = false
  } catch (e) {
    console.error('Error al guardar perfil:', e)
  }
}

// Al montar, cargamos perfil
onMounted(loadPerfil)
</script>

<style scoped>
.fill-height {
  height: 100vh;
}
.ml-2 {
  margin-left: 8px;
}
</style>
