import { createRouter, createWebHistory} from 'vue-router'
const index = ()=> import('../views/IndexHome.vue')
const editor = ()=> import('../pages/editor/IndexEditor')
const about = ()=> import('../pages/about/AboutIndex')
const classification = ()=> import('../pages/classification/ClassificationIndex')
const article = ()=> import('../views/ArticleInfo')
const editorArticle = ()=> import('../pages/editor/EditorArticle')


const routes = [
    {path: '/',name: 'index',component: index},
    {path: '/editor',name: 'editor',component:editor},
    {path: '/article/:uuid',name: 'article',component:article},
    {path: '/editorArticle/:uuid',name: 'editorArticle',component:editorArticle},
    {path: '/about',name: 'about',component:about},
    {path: '/classification',name: 'classification',component:classification}
]
const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router