package com.fowobi.h2mysql;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class H2mysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2mysqlApplication.class, args);
	}

	@Bean
	JdbcTemplate jdbcTemplate(@Qualifier("secondary") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	CommandLineRunner runner(@Qualifier("primary") DataSource dataSource) {
		return args -> {
			System.out.println("Inside runner");
			System.out.println(dataSource.getConnection().getMetaData().getURL());
		};
	}

	@Bean
	CommandLineRunner runner2(@Qualifier("secondary") DataSource dataSource) {
		return args -> {
			System.out.println("Inside runner 2");
			System.out.println(dataSource.getConnection().getMetaData().getURL());
		};
	}
}
