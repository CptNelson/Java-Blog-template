<template>
	<nav
		class="px-2 py-2 bg-blue-200 border-gray-200 rounded sm:px-4 dark:bg-gray-800"
	>
		<router-link :to="{ name: 'Home' }">
			<h1 class="pt-8 mt-4 text-3xl text-center hover:text-blue-500">
				Pretty Nice Blog
			</h1>
		</router-link>
		<div class="flex flex-row text-xl">
			<router-link
				:to="{ name: 'Home' }"
				class="block py-2 pl-3 pr-4 hover:text-blue-500"
			>
				Home
			</router-link>
			<router-link
				:to="{ name: 'new-post' }"
				class="block py-2 pl-3 pr-4 hover:text-blue-500"
			>
				Add new post
			</router-link>
		</div>
	</nav>
</template>
