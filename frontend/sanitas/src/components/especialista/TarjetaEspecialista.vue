<template>
  <v-card class="mx-auto my-4" max-width="400">
    <!-- Imagen de avatar -->
    <v-img
        :src="avatar"
        height="200"
        class="white--text align-end"
    >
      <!-- Opcional: overlay con nombre -->
      <v-card-title class="bg-black bg-opacity-50">
        {{ especialista.nombre }}
      </v-card-title>
    </v-img>

    <!-- Especialidad debajo de la imagen -->
    <v-card-subtitle class="text-subtitle-1 px-4 pt-2">
      {{ especialista.especialidad }}
    </v-card-subtitle>

    <!-- Descripción y puntuación -->
    <v-card-text class="px-4">
      {{ especialista.descripcion }}
      <div class="mt-2 d-flex align-center">
        <v-rating
            v-model="rating"
            readonly
            dense
            size="20"
            half-increments
        />
        <span class="ml-2">{{ especialista.puntuacion.toFixed(1) }}</span>
      </div>
    </v-card-text>

    <!-- Acción: ver perfil -->
    <v-card-actions class="px-4">
      <v-spacer />
      <v-btn text @click="verPerfil">
        Ver perfil
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import avatar from '@/assets/avatar.png'

// Prop de especialista según contrato
const props = defineProps({
  especialista: {
    type: Object,
    required: true
  }
})

// Rating local basado en la puntuación (decimal soportado con half-increments)
const rating = ref(props.especialista.puntuacion)
const router = useRouter()

function verPerfil() {
  router.push({
    name: 'Perfil',
    params: {id: props.especialista.idEspecialista}
  })
}
</script>

<style scoped>
.mx-auto {
  margin-left: auto;
  margin-right: auto;
}

.my-4 {
  margin: 16px 0;
}

.mt-2 {
  margin-top: 8px;
}

.ml-2 {
  margin-left: 8px;
}
</style>