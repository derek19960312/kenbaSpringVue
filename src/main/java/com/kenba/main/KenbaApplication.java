package com.kenba.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.kenba.controller" })
//@EnableJpaRepositories(basePackages = { "com.kenba.repository" })
public class KenbaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KenbaApplication.class, args);
	}

}
