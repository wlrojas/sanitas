<template>
  <v-container fluid class="pa-8">
    <!-- Título y volver -->
    <v-row align="center" class="mb-6">
      <v-col cols="auto">
        <v-btn icon @click="goBack">
          <v-icon>mdi-arrow-left</v-icon>
        </v-btn>
      </v-col>
      <v-col>
        <span class="text-h5">Mi Historial Médico</span>
      </v-col>
    </v-row>

    <!-- Resumen general -->
    <v-card class="mb-6" elevation="2">
      <v-card-title>Resumen</v-card-title>
      <v-card-text>
        <div v-if="historial.resumen">{{ historial.resumen }}</div>
        <v-alert v-else type="info">No hay resumen disponible.</v-alert>
      </v-card-text>
    </v-card>

    <!-- Lista de exámenes -->
    <v-card elevation="2">
      <v-card-title>Exámenes</v-card-title>
      <v-data-table
          :headers="headers"
          :items="historial.examenes"
          :items-per-page="5"
          class="elevation-0"
      >
        <!-- Si no hay exámenes -->
        <template #no-data>
          <v-alert type="info" class="ma-4">
            No hay exámenes registrados.
          </v-alert>
        </template>
      </v-data-table>
    </v-card>
  </v-container>
</template>

<script setup>
import { reactive, ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import servicioHistorial from '@/services/servicioHistorial'

// Router y “volver”
const router = useRouter()
const goBack = () => router.back()

// Estado del historial
const historial = reactive({
  resumen: '',
  examenes: []
})

// Columnas de la tabla de exámenes
const headers = [
  { text: 'Nombre de examen', value: 'nombre' },
  { text: 'Resultado',       value: 'resultado' },
  { text: 'Fecha',           value: 'fecha' }
]

// ID del paciente (desde login)
const pacienteId = localStorage.getItem('idUsuario')

// Carga del historial al montar
onMounted(async () => {
  try {
    const data = await servicioHistorial.getHistorial(pacienteId)
    historial.resumen  = data.resumen
    historial.examenes = data.examenes || []
  } catch (e) {
    console.error('Error al cargar historial médico', e)
  }
})
</script>

<style scoped>
.mb-6 {
  margin-bottom: 24px;
}
</style>
