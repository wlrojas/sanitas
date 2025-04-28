<script setup>
import { ref } from 'vue'
//Inicialización de variables para mostrar en pantalla, traer desde BD
const name = ref('Jhon')
const lastName = ref('Doe')
const email = ref('jh.doe@duocuc.cl')

//Inicialización de variables de entrada para editar los datos de usuario
const editName = ref('')
const editLastName = ref('')
const editEmail = ref('')
//Variable para modo edición de datos de perfil
const editeMode = ref(false)
//Funcion para iniciar el modo edicion de datos
function startEdition() {
  editName.value = name.value
  editLastName.value = lastName.value
  editEmail.value = email.value

  editeMode.value = true
}
//Guarda los cambios, se debera actualizar la BD
function saveChanges() {
  name.value = editName.value
  lastName.value = editLastName.value
  email.value = editEmail.value

  editeMode.value = false
}
//Cancelar modo edicion y se deja los datos como estaban
function cancelEdition() {
  editeMode.value = false
}
</script>

<template>
  <v-container class="fill-height pa-8" fluid>
    <v-row class="d-flex align-center justify-center fill-height">
      <v-col cols="12" md="8" lg="6">
        <!--Datos de usuario-->
        <v-card elevation="4" class="pa-8">
          <v-card-title class="justify-center text-h5 mb-4">
            Datos
          </v-card-title>
          <v-card-text>
            <!-- Datos de Usuario -->
            <v-row dense>
              <!-- Nombre -->
              <v-col cols="12" sm="6">
                <label>Nombre</label>
                <div v-if="!editeMode">
                  <h3>{{ name }}</h3>
                </div>
                <div v-else>
                  <v-text-field v-model="editName" label="Nombre" type="text" dense outlined />
                </div>
                <!-- Apellido -->
              </v-col>
              <v-col cols="12" sm="6">
                <label>Apellido</label>
                <div v-if="!editeMode">
                  <h3>{{ lastName }}</h3>
                </div>
                <div v-else>
                  <v-text-field v-model="editLastName" label="Apellido" type="text" dense outlined />
                </div>
              </v-col>
              <!-- Correo electrónico -->
              <v-col cols="12">
                <label>Correo electrónico</label>
                <div v-if="!editeMode">
                  <h3>{{ email }}</h3>
                </div>
                <div v-else>
                  <v-text-field v-model="editEmail" label="Correo electrónico" type="email" dense outlined />
                </div>

              </v-col>
              <!--Botones para modificar el perfil, ir a la seccion documentos medicos  o volver -->

              <!-- Botones para editar perfil -->
              <v-col cols="12" class="d-flex justify-center">
                <v-btn v-if="!editeMode" color="primary" class="ma-2" @click="startEdition">
                  Editar
                </v-btn>

                <div v-else class="d-flex">
                  <v-btn color="success" class="ma-2" @click="saveChanges">
                    Guardar
                  </v-btn>
                  <v-btn color="error" class="ma-2" @click="cancelEdition">
                    Cancelar
                  </v-btn>
                </div>
              </v-col>

              <!-- Otros botones -->
              <v-col cols="12" class="d-flex justify-center">
                <v-btn color="primary" class="ma-2" @click="$router.push('/documentos-medicos')">
                  Documentos medicos
                </v-btn>
              </v-col>
              <v-col cols="12" class="d-flex justify-center">
                <v-btn color="secondary" class="ma-2" @click="$router.push('/menu')">
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