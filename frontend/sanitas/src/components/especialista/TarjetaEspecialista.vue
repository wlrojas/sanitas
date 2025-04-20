<template>
  <v-card class="mx-auto" max-width="400">
    <v-card-title class="text-h6">
      {{ especialista.especialidad }}
    </v-card-title>
    <v-card-subtitle>
      {{ especialista.descripcion }}
    </v-card-subtitle>

    <v-divider class="my-2"/>

    <v-list dense>
      <v-subheader>Disponibilidad</v-subheader>
      <v-list-item
          v-for="slot in especialista.disponibilidad"
          :key="slot.fecha"
      >
        <v-list-item-content>
          <v-list-item-title>
            {{ slot.fecha }} — {{ slot.horas.join(', ') }}
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>

    <v-card-actions>
      <v-btn text color="primary" @click="verPerfil">
        Ver Perfil
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script setup>
import { defineProps } from 'vue'
import { useRouter } from 'vue-router'

const props = defineProps({
  especialista: { type: Object, required: true }
})

const router = useRouter()
const verPerfil = () => {
  router.push({ name: 'Perfil', params: { id: props.especialista.id } })
}
</script>
