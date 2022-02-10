<template>
	<main class="container px-8 pt-12 mx-auto lg:px-4">
		<PostList />
	</main>
</template>

<script>
import PostList from '@/components/PostList.vue';

export default {
	name: 'Home',
	components: {
		PostList,
	},
};
</script>
