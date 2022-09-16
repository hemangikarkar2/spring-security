package com.springsecutiyExample2.springsecutiryjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springsecutiyExample2.springsecutiryjpa.Repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)

public class SpringSecutiryJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecutiryJpaApplication.class, args);
	}

}
	