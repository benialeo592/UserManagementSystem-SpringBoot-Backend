package com.leone.ums;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.util.Objects;

@SpringBootApplication
public class UserManagementSystemApplication {

/*
	@Bean
	public CommandLineRunner runScript(JdbcTemplate jdbcTemplate) {
		return args -> {
            Resource resource = new ClassPathResource("data.sql");
            ScriptUtils.executeSqlScript(Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection(), resource);
       };
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(UserManagementSystemApplication.class, args);
	}

}
