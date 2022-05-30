package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		try {
			Path images = Paths.get("./static/images/");
			Files.createDirectories(images);
		} catch (FileAlreadyExistsException ignored) {
		}

		SpringApplication.run(DemoApplication.class, args);
	}
}
