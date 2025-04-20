<template>
  <v-container class="pa-4">
    <v-text-field
        v-model="termino"
        label="Buscar por nombre o especialidad"
        clearable
        outlined
    />

    <v-row class="mt-6" dense>
      <v-col
          v-for="esp in especialistas"
          :key="esp.id"
          cols="12" sm="6" md="4"
      >
        <TarjetaEspecialista :especialista="esp" />
      </v-col>

      <v-col v-if="!especialistas.length && termino.trim()" cols="12">
        <v-alert type="info">No se encontraron especialistas.</v-alert>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import {ref, watch} from 'vue'
import debounce from 'lodash/debounce'
import servicioEspecialistas from '@/services/servicioEspecialistas'
import TarjetaEspecialista from '@/components/especialista/TarjetaEspecialista.vue'

const termino = ref('')
const especialistas = ref([])

const doSearch = async () => {
  const q = termino.value.trim()
  console.log('Buscando especialistas con filtro:', q)
  try {
    especialistas.value = await servicioEspecialistas.buscar(q)
    console.log('Resultado:', especialistas.value)
  } catch (e) {
    console.error('Error buscando especialistas:', e)
    especialistas.value = []
  }
}

const buscar = debounce(doSearch, 300)
watch(termino, buscar)
</script>
