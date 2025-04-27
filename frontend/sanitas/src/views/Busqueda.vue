<template>
  <v-app>
    <v-sheet class="fill-height" color="grey lighten-4">
      <!-- Contenedor principal con ancho fijo y centrado -->
      <div class="search-container">
        <!-- Campo de búsqueda -->
        <v-text-field
            v-model="termino"
            label="Buscar especialistas..."
            placeholder="Escriba nombre o especialidad"
            outlined
            clearable
            @input="onInput"
        />

        <!-- Mensaje de sin resultados -->
        <div
            v-if="termino.trim() && especialistas.length === 0"
            class="text-center no-results"
        >
          No se encontraron especialistas.
        </div>

        <!-- Grid de tarjetas con 3 columnas fijas -->
        <div v-if="especialistas.length > 0" class="cards-grid">
          <TarjetaEspecialista
              v-for="esp in especialistas"
              :key="esp.idEspecialista"
              :especialista="esp"
          />
        </div>
      </div>
    </v-sheet>
  </v-app>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import debounce from 'lodash/debounce'
import servicioEspecialistas from '@/services/servicioEspecialistas'
import TarjetaEspecialista from '@/components/especialista/TarjetaEspecialista.vue'

const termino = ref('')
const especialistas = ref([])

// Carga inicial: trae todos los especialistas al montar
onMounted(async () => {
  try {
    especialistas.value = await servicioEspecialistas.buscar('')
  } catch {
    especialistas.value = []
  }
})

// Debounce de 300ms para llamadas de búsqueda
const buscar = debounce(async (q) => {
  try {
    especialistas.value = await servicioEspecialistas.buscar(q.trim())
  } catch {
    especialistas.value = []
  }
}, 300)

function onInput() {
  buscar(termino.value)
}
</script>

<style scoped>
.search-container {
  max-width: 1248px; /* 3 columnas de 400px + 2 gaps de 24px */
  margin: 0 auto;
  padding: 16px;
}

.cards-grid {
  display: grid;
  grid-template-columns: repeat(3, 400px);
  gap: 24px;
  justify-content: center;
  margin-top: 24px;
}

.text-center.no-results {
  text-align: center;
  margin: 32px 0;
}
</style>
