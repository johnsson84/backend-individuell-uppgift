package com.example.backendlibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class BackendLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendLibraryApplication.class, args);
	}

}
