import { createRouter, createWebHistory} from 'vue-router'
const index = ()=> import('../views/IndexHome.vue')
const editor = ()=> import('../pages/editor/IndexEditor')
const routes = [
    {path: '/',name: 'index',component: index},
    {path: '/editor',name: 'editor',component:editor}
]
const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router