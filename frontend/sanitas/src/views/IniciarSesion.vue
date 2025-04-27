<template>
  <v-container class="fill-height d-flex align-center justify-center" fluid>
    <v-card width="400" elevation="4" class="pa-6">
      <v-card-title class="justify-center text-h5">
        Iniciar sesión
      </v-card-title>
      <v-card-text>
        <v-form @submit.prevent="onSubmit">
          <v-text-field
              v-model="email"
              label="Correo electrónico"
              type="email"
              required
              outlined
          />

          <v-text-field
              v-model="password"
              label="Contraseña"
              type="password"
              required
              outlined
          />

          <v-btn
              type="submit"
              color="primary"
              class="mt-4"
              block
          >
            Iniciar sesión
          </v-btn>
        </v-form>
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script setup>
import { ref } from 'vue'

const email = ref('')
const password = ref('')

function onSubmit() {
  // TODO: integrar servicio de autenticación JWT y almacenar token
  console.log('Intento de inicio de sesión:', email.value)
}
</script>

<style scoped>
.fill-height {
  height: 100vh;
}
</style>
