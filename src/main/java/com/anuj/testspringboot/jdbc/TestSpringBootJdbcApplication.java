package com.anuj.testspringboot.jdbc;

import com.anuj.testspringboot.SomeRandomComponent;
import com.anuj.testspringboot.SomeRandomPrototypeComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestSpringBootJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringBootJdbcApplication.class, args);
	}

}
