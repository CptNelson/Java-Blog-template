import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/views/Home.vue';
import BlogPost from '@/views/BlogPost.vue';
import PageNotFound from '@/views/PageNotFound.vue';
import NewPost from '@/views/NewPost.vue';

const routes = [
	{
		path: '/',
		name: 'Home',
		component: Home,
	},
	{
		path: '/new',
		name: 'new-post',
		component: NewPost,
	},
	{
		path: '/posts/:id',
		name: 'post',
		component: BlogPost,
		props: true,
	},
	{
		path: '/:catchAll(.*)*',
		name: 'PageNotFound',
		component: PageNotFound,
	},
];

const router = createRouter({
	history: createWebHistory(),
	routes,
});

export default router;
