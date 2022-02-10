<template>
	<article
		class="flex flex-col p-6 border-8 border-white rounded-md bg-blue-50 lg:w-1/3 md:w-full"
	>
		<h2 class="mb-3 text-lg lg:text-2xl" v-if="post.title">
			{{ post.title }}
		</h2>
		<div class="py-1 text-xs text-gray-600">
			{{ new Date(post.date).toDateString() }}
		</div>
		<p class="flex-1 mb-4 leading-relaxed" v-if="post.body">
			{{ post.body.substr(0, 300) + '...' }}
		</p>

		<div>
			<router-link
				:to="{
					name: 'post',
					params: { id: post.id },
				}"
				v-slot="{ href, navigate }"
			>
				<button
					:href="href"
					@click="navigate"
					class="px-4 py-2 mb-4 mr-10 font-bold text-white bg-blue-500 rounded hover:bg-blue-700"
				>
					View
				</button>
			</router-link>

			<button
				@click="deletePost"
				class="bg-red-500 hover:bg-red-700 text-white font-bold my-4 py-1.5 px-4 rounded mb-4"
			>
				Delete
			</button>
		</div>
	</article>
</template>

<script>
import axios from 'axios';
export default {
	name: 'Card',
	props: ['post'],
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
				this.$emit('delete-event');
			} catch (err) {
				console.error(err);
			}
		},
	},
};
</script>
