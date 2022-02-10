<template>
	<main
		class="container flex flex-col items-center justify-center px-8 pt-12 mx-auto lg:px-4"
	>
		<h2 class="pb-10 text-2xl">Create new post</h2>
		<div class="items-start px-40 py-10 bg-gray-200">
			<div :class="{ invisible: !isSend }" class="text-xl text-green-500">
				Success!
				<router-link
					class="text-black hover:text-blue-500"
					v-if="postId"
					:to="{
						name: 'post',
						params: { id: postId },
					}"
				>
					Click here to see your post.
				</router-link>
			</div>

			<div :class="{ invisible: !isFailure }" class="text-red-500">
				Error! something went wrong.
			</div>

			<form @submit.prevent="submitForm">
				<p>Title</p>
				<p>
					<input
						type="text"
						v-model="title"
						placeholder="Title"
						class="mb-8 text-lg w-80"
						required="true"
						maxlength="40"
					/>
				</p>

				<p>Text</p>
				<p>
					<textarea
						v-model="text"
						placeholder="Write your content here. Max length is 4000 characters."
						class="pb-64 w-96"
						required="true"
						maxlength="4000"
					></textarea>
				</p>
				<p class="limiter">{{ charactersLeft }}</p>

				<button
					type="submit"
					class="px-4 py-2 my-4 mr-10 font-bold text-white bg-blue-500 rounded hover:bg-blue-700"
				>
					Save Post
				</button>
			</form>
		</div>
	</main>
</template>

<script>
import axios from 'axios';

export default {
	name: 'NewPost',
	data() {
		return {
			title: '',
			text: '',
			isSend: false,
			isFailure: false,
			postId: undefined,
		};
	},
	computed: {
		charactersLeft() {
			var char = this.text.length,
				limit = 4000;

			return `${limit - char} / ${limit} characters remaining`;
		},
	},
	methods: {
		async submitForm() {
			const newPost = { title: this.title, text: this.text };
			try {
				const res = await axios.post(
					process.env.VUE_APP_API_URL,
					newPost,
					{
						headers: {
							// remove headers
						},
					}
				);
				this.postId = res.data.id;
				this.isSend = true;
			} catch (err) {
				console.error(err);
				this.isFailure = true;
			}
		},
	},
};
</script>
