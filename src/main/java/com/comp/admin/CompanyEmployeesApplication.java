package com.comp.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories
@SpringBootApplication
@EntityScan("com.comp.admin.model")
public class CompanyEmployeesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyEmployeesApplication.class, args);
	}
}
