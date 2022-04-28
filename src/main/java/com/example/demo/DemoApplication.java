package com.example.demo;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

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

	/**
	 * Start internal H2 server to interact with the DB from IDEA
	 * Connection type: Remote
	 * Database: mem
	 * URL: jdbc:h2:tcp://localhost:8081/mem:demo
	 *
	 * @return H2 Server instance
	 */
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server() throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "8081");
	}

}
