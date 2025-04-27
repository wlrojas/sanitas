import { createApp } from 'vue'
import App from './App.vue'
import 'vuetify/styles'
import '@mdi/font/css/materialdesignicons.css'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives  from 'vuetify/directives'
import router from './router'
import { createPinia } from 'pinia'
import './assets/style.css'
const pinia = createPinia()

const vuetify = createVuetify({
    components,
    directives,
})

const app = createApp(App)
app
    .use(vuetify)
    .use(router)
    .use(pinia)
    .mount('#app')
