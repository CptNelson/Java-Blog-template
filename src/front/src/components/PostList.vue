<template>
	<div
		:class="{ invisible: !isDeleteSuccess }"
		class="flex justify-center text-xl text-green-500"
	>
		Post deleted succesfully.
	</div>

	<div v-if="!posts.length" class="flex justify-center text-2xl">
		No posts in the database.
	</div>

	<section class="flex flex-wrap">
		<Card
			@delete-event="deletedPost"
			v-for="post in posts"
			:key="post.id"
			:post="{
				title: post.title,
				body: post.text,
				date: post.date,
				id: post.id,
			}"
		></Card>
	</section>
</template>

<script>
import axios from 'axios';
import Card from '@/components/Card.vue';

export default {
	name: 'PostList',
	data() {
		return {
			posts: [],
			isDeleteSuccess: false,
		};
	},
	beforeMount() {
		this.getPosts();
	},
	components: { Card },
	methods: {
		async getPosts() {
			try {
				const res = await axios.get(process.env.VUE_APP_API_URL, {
					headers: {
						// remove headers
					},
				});
				this.posts = res.data;
			} catch (err) {
				console.error(err);
			}
		},

		deletedPost() {
			this.getPosts();
			this.isDeleteSuccess = true;
			setTimeout(() => (this.isDeleteSuccess = false), 5000);
		},
	},
};
</script>
