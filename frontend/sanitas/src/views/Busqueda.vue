<template>
  <!-- Hero con fondo y search bar fija -->
  <v-sheet min-height="40vh" class="hero">
    <v-img src="/assets/health-bg.jpg" class="hero-img" cover></v-img>
    <v-overlay absolute opacity="0.6" color="#000"></v-overlay>

    <v-container fluid class="pa-0 d-flex align-center justify-center">
      <v-row align="center" class="search-row">
        <v-col cols="auto">
          <v-btn icon large color="white" @click="goBack">
            <v-icon>mdi-arrow-left</v-icon>
          </v-btn>
        </v-col>
        <v-col cols="12" sm="8" md="6">
          <v-text-field
              v-model="termino"
              label="Buscar especialistas..."
              placeholder="Escriba nombre o especialidad"
              outlined
              clearable
              dense
              hide-details
              @input="onInput"
              class="search-field white--text"
          />
        </v-col>
      </v-row>
    </v-container>
  </v-sheet>

  <!-- Resultados de búsqueda -->
  <v-container fluid class="results-container">
    <v-row v-if="termino.trim() && especialistas.length === 0" justify="center">
      <v-col cols="12" class="no-results text-center">
        No se encontraron especialistas.
      </v-col>
    </v-row>
    <v-row v-else dense justify="center" class="cards-grid">
      <v-col
          v-for="esp in especialistas"
          :key="esp.idEspecialista"
          cols="12"
          sm="6"
          md="4"
          lg="3"
      >
        <TarjetaEspecialista :especialista="esp" />
      </v-col>
    </v-row>
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

function goBack() {
  router.back()
}

onMounted(async () => {
  especialistas.value = await servicioEspecialistas.buscar('')
})

const buscar = debounce(async q => {
  especialistas.value = await servicioEspecialistas.buscar(q.trim())
}, 300)

function onInput() {
  buscar(termino.value)
}
</script>

<style scoped>
.hero {
  position: relative;
  overflow-y: auto;
}
.hero-img {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -2;
}
.search-row {
  width: 90vw;
  max-width: 800px;
}
.search-field .v-input__control {
  background: rgba(255,255,255,0.9);
}
.results-container {
  padding-top: 32px;
  padding-bottom: 32px;
}
.cards-grid {
  width: 90vw;
  max-width: 1200px;
}
.no-results {
  font-size: 1.2rem;
  color: rgba(0, 0, 0, 0.6);
  margin: 24px 0;
}
</style>