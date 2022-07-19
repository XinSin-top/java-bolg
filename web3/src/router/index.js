import { createRouter, createWebHistory} from 'vue-router'
const index = ()=> import('../views/IndexHome.vue')
const routes = [
    {path: '/',name: 'index',component: index}
]
const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router