<template>
	<div>
		<div class="container pt-2 mx-auto lg:pt-12 lg:w-3/5">
			<router-link
				:class="{ invisible: !isDeleteSuccess }"
				:to="{ name: 'Home' }"
				class="mx-auto text-2xl hover:text-blue-500"
			>
				Post deleted succesfully. Click here to go back to home page.
			</router-link>
		</div>

		<main
			:class="{ invisible: isDeleteSuccess }"
			class="container mx-auto rounded-md bg-blue-50 lg:w-3/5"
		>
			<article class="px-6 pt-6 md:pt-12 md:px-12">
				<h2 class="text-2xl lg:text-2xl">
					{{ post.title }}
				</h2>
				<div class="py-1 mb-4 text-xs text-gray-600">
					{{ new Date(post.date).toDateString() }}
				</div>
				<p class="mb-12 leading-relaxed">{{ post.text }}</p>
				<button
					@click="deletePost"
					class="bg-red-500 hover:bg-red-700 text-white font-bold my-4 py-1.5 px-4 rounded"
				>
					Delete
				</button>
			</article>
		</main>
	</div>
</template>

<script>
import axios from 'axios';
export default {
	props: ['id'],
	data() {
		return {
			post: {},
			isDeleteSuccess: false,
		};
	},
	beforeMount() {
		axios
			.get(`${process.env.VUE_APP_API_URL}${this.$route.params.id}`, {
				headers: {
					// remove headers
				},
			})
			.then((response) => (this.post = response.data));
	},
	methods: {
		async deletePost() {
			try {
				await axios.delete(
					`${process.env.VUE_APP_API_URL}${this.post.id}`,
					{
						headers: {
							// remove headers
						},
					}
				);
				this.isDeleteSuccess = true;
			} catch (err) {
				console.error(err);
			}
		},
	},
};
</script>
