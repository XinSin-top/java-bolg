import { createRouter, createWebHistory} from 'vue-router'
const HelloWorld = ()=> import('../components/HelloWorld.vue')
const routes = [
    {path: '/',name: 'helloWorld',component: HelloWorld}
]
const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router