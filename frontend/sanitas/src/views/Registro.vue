<script setup>
import { ref } from 'vue'

let name = ref('')
let rol = ref('')
let password = ref('')
let passwordVerify = ref('')
let email = ref('')
let phone = ref()

</script>

<template>
  <v-container class="fill-height pa-8" fluid>
    <v-row class="d-flex align-center justify-center fill-height">
      <v-col cols="12" md="8" lg="6">
        <!--Formulario de Registro de usuario-->
        <v-card elevation="4" class="pa-8">
          <v-card-title class="justify-center text-h5 mb-4">
            Registro
          </v-card-title>
          <v-card-text>
            <v-row dense>

              <v-col cols="12">
                <v-select v-model="rol" label="Tipo de usuario"
                  :items="['Paciente', 'Especialista']"></v-select>
              </v-col>

              <v-col cols="12">
                <v-text-field v-model="name" label="Nombre completo" type="text" required outlined />
              </v-col>

              <v-col cols="12">
                <v-text-field v-model="email" label="Correo electrónico" type="email" required outlined />
              </v-col>

              <v-col cols="12">
                <v-number-input v-model="phone" control-variant="hidden" label="Teléfono (+56 9)" :precision="0" :min="10000000" :max="99999999"></v-number-input>
              </v-col>

              <v-col cols="12">
                <v-text-field v-model="password" label="Contraseña" type="password" required outlined />
              </v-col>

              <v-col cols="12">
                <v-text-field v-model="passwordVerify" label="Repetir contraseña" type="password" required outlined />
              </v-col>
              <!--Botones para confirmar el registro o para cancelar y volver -->
              <v-col cols="12" class="d-flex justify-center">
                <v-btn type="submit" color="primary" class="ma-2" @click="$router.push('/menu')">
                  Registrarse
                </v-btn>
                <v-btn color="secondary" outlined class="ma-2" @click="$router.push('/')">
                  Volver
                </v-btn>
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<style scoped></style>
