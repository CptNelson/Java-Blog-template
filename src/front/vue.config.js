module.exports = {
	// https://cli.vuejs.org/config/#devserver-proxy
	devServer: {
		port: 3000,
		proxy: {
			'^/api': {
				target: 'http://localhost:8080/posts',
				ws: true,
				changeOrigin: true,
				pathRewrite: { '^/api': '/api' },
				logLevel: 'debug',
			},
		},
	},
};
