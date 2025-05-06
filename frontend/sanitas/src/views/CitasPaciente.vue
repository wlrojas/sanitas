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
        <span class="text-h5">Mis citas</span>
      </v-col>
    </v-row>

    <!-- Filtro de estado -->
    <v-row class="mb-4">
      <v-col cols="12">
        <v-btn-toggle v-model="filter" mandatory>
          <v-btn value="todas">Todas</v-btn>
          <v-btn value="procesando">En espera</v-btn>
          <v-btn value="realizada">Realizadas</v-btn>
        </v-btn-toggle>
      </v-col>
    </v-row>

    <!-- Tabla de citas sin columna de especialista -->
    <v-data-table
        :headers="headers"
        :items="citasFiltradas"
        :items-per-page="5"
        class="elevation-1"
    >
      <!-- Estado con chip -->
      <template #item.status="{ item }">
        <v-chip
            :color="item.status === 'procesando' ? 'warning' : 'success'"
            small
            dark
        >
          {{ item.status === 'procesando' ? 'En espera' : 'Realizada' }}
        </v-chip>
      </template>

      <!-- Si no hay datos -->
      <template #no-data>
        <v-alert type="info" class="ma-4">
          No hay citas para mostrar.
        </v-alert>
      </template>
    </v-data-table>
  </v-container>
</template>

<script setup>
import { ref, onMounted, computed } from 'vue'
import { useRouter } from 'vue-router'
import servicioCitas from '@/services/servicioCitas'

// Router y “volver”
const router = useRouter()
const goBack = () => router.back()

// Estado de citas y filtro
const citas = ref([])
const filter = ref('todas')

// Cabeceras SIN la columna de especialista
const headers = [
  { text: 'Fecha',  value: 'fecha' },
  { text: 'Hora',   value: 'hora' },
  { text: 'Estado', value: 'status' }
]

// ID del paciente
const pacienteId = localStorage.getItem('idUsuario')

// Carga inicial de citas
async function loadCitas() {
  citas.value = await servicioCitas.getCitasPaciente(pacienteId)
}

onMounted(loadCitas)

// Computed para filtrar según estado
const citasFiltradas = computed(() =>
    citas.value.filter(c =>
        filter.value === 'todas' ? true : c.status === filter.value
    )
)
</script>

<style scoped>
.mb-6 {
  margin-bottom: 24px;
}

.mb-4 {
  margin-bottom: 16px;
}
</style>
