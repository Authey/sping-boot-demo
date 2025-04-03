import {createApp} from 'vue';
import ElementPlus from 'element-plus';
import 'element-plus/theme-chalk/index.css';
import App from './App.vue';
import Router from "@/router/index.js";
import {createPinia} from 'pinia';
import {createPersistedState} from "pinia-persistedstate-plugin";
import 'remixicon/fonts/remixicon.css'

const pinia = createPinia()
const persist = createPersistedState()
pinia.use(persist)

const app = createApp(App)
app.use(ElementPlus)
app.use(pinia)
app.use(Router)

app.mount('#app')
