<template>
  <v-container fluid class="pa-8">
    <!-- 1) Fila con botón Atrás y campo de búsqueda -->
    <v-row class="mb-6" align="center">
      <v-col cols="auto">
        <v-btn icon @click="goBack">
          <v-icon>mdi-arrow-left</v-icon>
        </v-btn>
      </v-col>
      <v-col>
        <v-text-field
            v-model="termino"
            label="Buscar especialistas..."
            placeholder="Escriba nombre o especialidad"
            outlined
            clearable
            dense
            style="width: 100%;"
            @input="onInput"
        />
      </v-col>
    </v-row>

    <!-- 2) Mensaje “no hay resultados” -->
    <v-row
        v-if="termino.trim() && especialistas.length === 0"
        justify="center"
    >
      <v-col cols="12" class="text-center no-results">
        No se encontraron especialistas.
      </v-col>
    </v-row>

    <!-- 3) Grilla fija de 3 columnas -->
    <div v-else class="cards-grid">
      <div
          v-for="esp in especialistas"
          :key="esp.idEspecialista"
          class="card-wrap"
      >
        <TarjetaEspecialista :especialista="esp" />
      </div>
    </div>
  </v-container>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import debounce from 'lodash/debounce'
import servicioEspecialistas from '@/services/servicioEspecialistas'
import TarjetaEspecialista from '@/components/especialista/TarjetaEspecialista.vue'

const router = useRouter()
const termino = ref('')
const especialistas = ref([])

// Función para volver atrás
function goBack() {
  router.back()
}

// Carga inicial de todos los especialistas
onMounted(async () => {
  especialistas.value = await servicioEspecialistas.buscar('')
})

// Debounce para filtrar conforme escribes
const buscar = debounce(async q => {
  especialistas.value = await servicioEspecialistas.buscar(q.trim())
}, 300)

function onInput() {
  buscar(termino.value)
}
</script>

<style scoped>
.no-results {
  margin: 32px 0;
  font-size: 1.1rem;
  color: rgba(0, 0, 0, 0.6);
  text-align: center;
}

/* Grilla fija de 3 columnas de 300px */
.cards-grid {
  display: grid;
  grid-template-columns: repeat(3, 300px);
  gap: 24px;
  justify-content: center;
}

/* Cada tarjeta siempre 300px de ancho */
.card-wrap {
  width: 300px;
}
</style>
