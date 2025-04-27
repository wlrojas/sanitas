<script setup>
</script>

<template>
  <v-container class="fill-height pa-8" fluid>
    <v-row class="d-flex align-center justify-center fill-height">
      <v-col cols="12" md="8" lg="6">
        <!--Botones para Moverse entre paginas o cerrar sesion-->
        <v-card elevation="4" class="pa-8">
          <v-card-title class="justify-center text-h5 mb-4">
            Menu Principal
          </v-card-title>
          <v-card-text>
            <v-row dense>
              <v-col cols="12">
                <v-btn block color="primary" class="ma-2" @click="$router.push('/busqueda')">
                  Busqueda de Especialista
                </v-btn>
              </v-col>
              <v-col cols="12">
                <!--Se le pasa una ID temporal para lograr moverse entre paginas-->
                <v-btn block color="primary" class="ma-2" @click="$router.push('/perfil/1')">
                  Perfil personal
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
