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
        <span class="text-h5">Citas Agendadas</span>
      </v-col>
    </v-row>

    <!-- Filtro -->
    <v-row class="mb-4">
      <v-col cols="12">
        <v-btn-toggle v-model="filter" mandatory>
          <v-btn value="todas">Todas</v-btn>
          <v-btn value="procesando">En espera</v-btn>
          <v-btn value="realizada">Realizadas</v-btn>
        </v-btn-toggle>
      </v-col>
    </v-row>

    <!-- Tabla -->
    <v-data-table
        :headers="headers"
        :items="citasFiltradas"
        :items-per-page="5"
        class="elevation-1"
    >
      <!-- Mostrar nombre del paciente -->
      <template #item.idPaciente="{ item }">
        {{ nombres[item.idPaciente] || item.idPaciente }}
      </template>

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

      <template #no-data>
        <v-alert type="info" class="ma-4">
          No hay citas agendadas.
        </v-alert>
      </template>
    </v-data-table>
  </v-container>
</template>

<script setup>
import {ref, onMounted, reactive, computed} from 'vue'
import {useRouter} from 'vue-router'
import servicioCitas from '@/services/servicioCitas'
import servicioUsuario from '@/services/servicioUsuario'
import servicioEspecialistas from '@/services/servicioEspecialistas'

const router = useRouter()
const goBack = () => router.back()

const citas = ref([])
const filter = ref('todas')
const nombres = reactive({})

// Columnas: mantenemos idPaciente para el slot
const headers = [
  {text: 'Paciente', value: 'idPaciente'},
  {text: 'Fecha', value: 'fecha'},
  {text: 'Hora', value: 'hora'},
  {text: 'Estado', value: 'status'}
]

// 1) Obtener idUsuario del especialista
const usuarioId = localStorage.getItem('idUsuario')

async function loadCitas() {
  // 2) Obtener el objeto especialista para extraer idEspecialista
  const esp = await servicioEspecialistas.getByUsuario(usuarioId)
  const idEsp = esp.idEspecialista

  // 3) Traer citas usando idEspecialista
  const data = await servicioCitas.getCitasEspecialista(idEsp)
  citas.value = data

  // 4) Cargar nombres de pacientes
  const idsPac = [...new Set(data.map(c => c.idPaciente))]
  await Promise.all(
      idsPac.map(async id => {
        const perf = await servicioUsuario.getPerfil(id)
        nombres[id] = perf.nombre
      })
  )
}

onMounted(loadCitas)

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
