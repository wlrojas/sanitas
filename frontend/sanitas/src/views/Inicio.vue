<template>
  <v-container fluid class="pa-0">
    <!-- Hero Section -->
    <v-sheet height="70vh" color="primary" class="d-flex align-center justify-center hero">
      <!-- Imagen de fondo con overlay semitransparente -->
      <v-img src="/assets/health-bg.jpg" class="hero-img" cover></v-img>
      <v-overlay absolute opacity="0.6" color="#000"></v-overlay>

      <!-- Contenido central del Hero -->
      <div class="hero-content text-center px-4">
        <h1 class="display-2 font-weight-bold white--text">Bienvenido a Sanitas</h1>
        <p class="subtitle-1 white--text mt-4">
          Tu plataforma de salud en línea. Encuentra y agenda citas con profesionales certificados.
        </p>
        <v-btn color="secondary" class="mt-6" large dark @click="$router.push('/registro')">
          Comenzar
        </v-btn>
      </div>
    </v-sheet>

    <!-- Sección de características principales -->
    <v-container class="mt-12">
      <v-row dense>
        <v-col cols="12" sm="4" v-for="item in features" :key="item.title">
          <v-card class="pa-6 elevation-3 text-center">
            <v-icon size="48" color="primary">{{ item.icon }}</v-icon>
            <h3 class="headline font-weight-medium mt-4">{{ item.title }}</h3>
            <p class="body-1 mt-2">{{ item.description }}</p>
          </v-card>
        </v-col>
      </v-row>
    </v-container>

    <!-- Botones de llamada a la acción -->
    <v-container class="text-center mt-16 mb-16">
      <v-btn color="primary" class="ma-2" large @click="$router.push('/login')">
        Iniciar sesión
      </v-btn>
      <v-btn color="secondary" outlined class="ma-2" large @click="$router.push('/registro')">
        Registrarse
      </v-btn>
    </v-container>
  </v-container>
</template>

<script setup>
import { ref } from 'vue';

const features = ref([
  {
    icon: 'mdi-stethoscope',
    title: 'Profesionales Certificados',
    description: 'Verifica la experiencia y credenciales de cada especialista.',
  },
  {
    icon: 'mdi-calendar-check',
    title: 'Agenda Fácil',
    description: 'Elige fecha y hora en minutos, sin llamadas innecesarias.',
  },
  {
    icon: 'mdi-chat',
    title: 'Atención Online',
    description: 'Consulta vía videollamada desde la comodidad de tu hogar.',
  },
]);
</script>

<style scoped>
.hero {
  position: relative;
  overflow: hidden;
}
.hero-img {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -2;
}
.hero-content {
  z-index: 1;
}
</style>
