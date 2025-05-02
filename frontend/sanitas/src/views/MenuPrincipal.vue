<script setup>
</script>

<template>
  <v-container class="fill-height pa-8" fluid>
    <v-row class="fill-height d-flex align-center justify-center">
      <v-col cols="12" class="d-flex justify-center">
        <!-- Botones para moverse entre paginas -->
        <v-card elevation="6" class="pa-8" min-width="400" max-width="600">
          <v-card-title class="justify-center text-h5 mb-4">
            Menú Principal
          </v-card-title>
          <v-card-text>
            <v-row dense>
              <v-col cols="12">
                <v-btn block color="primary" class="ma-2" @click="$router.push('/busqueda')">
                  Búsqueda
                </v-btn>
              </v-col>
              <v-col cols="12">
                <v-btn block color="primary" class="ma-2" @click="$router.push('/perfil')">
                  Perfil
                </v-btn>
              </v-col>
              <v-col cols="12">
                <v-btn block color="secondary" class="ma-2" @click="$router.push('/')">
                  Salir
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
