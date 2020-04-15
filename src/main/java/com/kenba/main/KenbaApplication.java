package com.kenba.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.kenba.controller", "com.kenba.service", "com.kenba.filter" })
@EnableJpaRepositories(basePackages = { "com.kenba.repository" })
@EntityScan(basePackages = { "com.kenba.data" })
public class KenbaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KenbaApplication.class, args);
	}

}
