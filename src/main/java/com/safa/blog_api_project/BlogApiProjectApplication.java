package com.safa.blog_api_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BlogApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApiProjectApplication.class, args);
	}

}
