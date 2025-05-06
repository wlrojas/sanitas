<template>
  <v-container fluid class="pa-8">
    <!-- Título + volver -->
    <v-row align="center" class="mb-6">
      <v-col cols="auto">
        <v-btn icon @click="goBack">
          <v-icon>mdi-arrow-left</v-icon>
        </v-btn>
      </v-col>
      <v-col>
        <span class="text-h5">Mi Disponibilidad</span>
      </v-col>
    </v-row>

    <!-- 1) Calendario mensual con v-date-picker -->
    <v-row justify="center">
      <v-col cols="12" md="8" lg="6">
        <v-date-picker
            v-model="selectedDay"
            type="month"
            :events="eventDates"
            event-color="primary"
            color="primary"
            locale="es"
            show-current="true"
        />
      </v-col>
    </v-row>

    <!-- 2) Horas del día seleccionado -->
    <v-row class="mt-6" v-if="selectedHoras.length">
      <v-col cols="12">
        <h3>Horas disponibles en {{ formatFecha(selectedDay) }}</h3>
        <v-chip
            v-for="hora in selectedHoras"
            :key="hora"
            class="ma-1"
            small
        >
          {{ hora }}
        </v-chip>
      </v-col>
    </v-row>

    <!-- 3) Mensaje por defecto -->
    <v-row class="mt-6" v-else>
      <v-col cols="12" class="text-center">
        <v-icon size="48">mdi-calendar-range</v-icon>
        <p class="mt-2">
          Haz clic en un día resaltado para ver las horas disponibles.
        </p>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import servicioDisponibilidad from '@/services/servicioDisponibilidad.js'
import dayjs from 'dayjs'
import 'dayjs/locale/es'

dayjs.locale('es')

// Router + volver
const router = useRouter()
const goBack = () => router.back()

// Estado interno
const disponibilidad = ref([])      // lista de { fecha, horas }
const selectedDay = ref(null)       // fecha string YYYY-MM-DD

// Carga inicial
onMounted(async () => {
  const usuarioId = localStorage.getItem('idUsuario')
  disponibilidad.value =
      await servicioDisponibilidad.getDisponibilidadPorUsuario(usuarioId)
})

// Días que marcamos en el calendario
const eventDates = computed(() =>
    disponibilidad.value.map(d => d.fecha)
)

// Lista de horas para el día clicado
const selectedHoras = computed(() => {
  const d = disponibilidad.value.find(x => x.fecha === selectedDay.value)
  return d ? d.horas : []
})

// formatea para mostrar
function formatFecha(fecha) {
  return dayjs(fecha).format('DD [de] MMMM YYYY')
}
</script>

<style scoped>
.mb-6 { margin-bottom: 24px; }
.mt-2 { margin-top: 8px; }
.mt-6 { margin-top: 24px; }
.pa-8 { padding: 32px; }
.text-center { text-align: center; }
</style>
