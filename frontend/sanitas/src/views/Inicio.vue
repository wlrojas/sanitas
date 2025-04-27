<template>
  <v-container fluid class="pa-0">
    <!-- Hero inicial -->
    <v-sheet height="60vh" color="primary" class="d-flex align-center justify-center">
      <div class="text-center white--text">
        <h1 class="display-1 font-weight-bold">Bienvenido a Sanitas</h1>
        <p class="text-subtitle-1">
          Tu plataforma de salud en línea. Encuentra y agenda citas con profesionales certificados.
        </p>
      </div>
    </v-sheet>

    <!-- Sección de botones para Login y Registro -->
    <v-container class="button-section">
      <v-row justify="center" class="mt-8">
        <v-col cols="auto" class="d-flex">
          <v-btn color="primary" class="ma-2" @click="$router.push('/login')">
            Iniciar sesión
          </v-btn>
          <v-btn color="secondary" outlined class="ma-2" @click="$router.push('/registro')">
            Registrarse
          </v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-container>
</template>

<script setup>

</script>

<style scoped>
.button-section {
  margin-top: -100px;
  padding-bottom: 32px;
}
.mt-8 {
  margin-top: 64px;
}
</style>