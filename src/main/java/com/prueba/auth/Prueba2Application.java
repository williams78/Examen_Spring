package com.prueba.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class Prueba2Application {

	public static void main(String[] args) {
		SpringApplication.run(Prueba2Application.class, args);
	}

}
