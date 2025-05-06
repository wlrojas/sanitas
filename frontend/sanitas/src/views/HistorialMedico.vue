<script setup>
import { ref } from 'vue'

// Nuevo archivo que se sube
const newDocument = ref(null)

// Simulamos documentos de ejemplo
const documents = ref([
    { id: 1, name: 'Informe_medico.pdf', url: '' },
    { id: 2, name: 'Radiografia_torax.pdf', url: '' },
    { id: 3, name: 'Resultados_laboratorio.pdf', url: '' },
])

// Función para abrir documento (ahora no tiene una url real)
function openDocument(doc) {
    if (doc.url) {
        window.open(doc.url, '_blank')
    } else {
        alert('No hay un archivo disponible aún.')
    }
}

// Función para eliminar documento
function eliminateDocument(id) {
    documents.value = documents.value.filter(doc => doc.id !== id)
}

// Función para agregar un nuevo documento de prueba
function addDocument() {
    // Asignar un nombre basado en el archivo cargado
    const fileName = newDocument.value.name;
    const newId = documents.value.length + 1;

    // Simulamos la subida del archivo (puedes agregar una URL real más tarde)
    documents.value.push({
        id: newId,
        name: fileName,
        url: '' // URL vacía por ahora
    });

    // Limpiar el archivo seleccionado después de agregarlo
    newDocument.value = null;
}
</script>

<template>
    <v-container class="fill-height pa-8" fluid>
        <v-row class="d-flex align-center justify-center fill-height">
            <!-- Ajustar la columna para hacerla más ancha -->
            <v-col cols="12" class="d-flex justify-center">
                <!-- Tarjeta centrada y más ancha -->
                <v-card elevation="4" class="pa-8">
                    <v-btn color="primary" class="ma-2" @click="$router.push('/perfil')">Volver</v-btn>
                    <v-card-title class="d-flex justify-space-between align-center mb-4">
                        <span class="text-h5">Lista de documentos</span>
                    </v-card-title>
                    <v-card-subtitle>
                        <v-file-input v-model="newDocument" label="Subir Documento"></v-file-input>
                        <!-- Boton para agregar documento, solo cuando se cargue un documento-->
                        <v-btn v-if="newDocument" color="primary" @click="addDocument">Agregar Documento</v-btn>
                    </v-card-subtitle>
                    <v-card-text>
                        <v-list>
                            <v-list-item v-for="doc in documents" :key="doc.id" class="d-flex align-center">
                                <v-list-item-content>
                                    <v-list-item-title>{{ doc.name }}</v-list-item-title>
                                </v-list-item-content>
                                <v-list-item-action>
                                    <v-btn icon @click="openDocument(doc)">
                                        <!-- Ver documento -->
                                        <v-icon>mdi-eye</v-icon>
                                    </v-btn>
                                    <v-btn icon color="error" @click="eliminateDocument(doc.id)">
                                        <!-- Eliminar documento -->
                                        <v-icon>mdi-delete</v-icon>
                                    </v-btn>
                                </v-list-item-action>
                            </v-list-item>
                        </v-list>
                        <!-- Mostrar mensaje si no hay documentos -->
                        <div v-if="documents.length === 0" class="text-center mt-4">
                            No hay documentos disponibles.
                        </div>
                    </v-card-text>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<style scoped></style>
