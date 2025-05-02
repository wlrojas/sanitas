<script setup>
import { ref } from 'vue'

let idUsuario = ref()
let descripcion = ref("")
let especialidad = ref("")
let disponibilidad = ref([{
    "fecha": "",
    "horas": "",
}])

</script>

<template>
    <v-container class="fill-height pa-8" fluid>
        <v-row class="d-flex align-center justify-center fill-height">
            <v-col cols="12">
                <!--Formulario de Registro de usuario especialista-->
                <v-card elevation="4" class="pa-8">
                    <v-card-title class="justify-center text-h5 mb-4">
                        Registro Especialista
                    </v-card-title>
                    <v-card-text>
                        <v-row dense>

                            <v-col cols="12">
                                <v-select v-model="especialidad" label="Especialidad" required outlined :items="['Cardiología',
                                    'Quiropráctica',
                                    'Pediatría',
                                    'Medicina Tradicional China',
                                    'Ginecología y Obstetricia',
                                    'Naturopatía',
                                    'Neurología',
                                    'Osteopatía',
                                    'Oncología Integrativa',
                                    'Psicoterapia Holística',
                                    'Otro']"></v-select>
                            </v-col>

                            <v-col cols="12">
                                <v-textarea v-model="descripcion" label="descripción" maxlength="200" counter
                                    single-line required outlined></v-textarea>
                            </v-col>
                            <!-- Falta desarrollo para la implementacion de seleccion de hora y fecha de disponibilidad -->
                            <v-col cols="12">
                                <v-text-field v-model="disponibilidad"
                                    label="POR DESARROLLAR (Disponibilidad horas y fecha)" type="text" required outlined
                                    disabled />
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
