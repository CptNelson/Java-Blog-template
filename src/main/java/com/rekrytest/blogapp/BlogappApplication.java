package com.rekrytest.blogapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.SocketUtils;

import static com.rekrytest.blogapp.ServerPortCustomizer.getPort;


@SpringBootApplication
public class BlogappApplication {

	public static void main(String[] args) {
			System.getProperties().put( "server.port", getPort());
			SpringApplication.run(BlogappApplication.class, args);
	}
}

