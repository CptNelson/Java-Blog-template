<template>
	<Post :post="{ ...post }" />
</template>

<script>
import Post from '@/components/Post.vue';

export default {
	name: 'PostView',
	components: {
		Post,
	},
	props: ['post'],
};
</script>
