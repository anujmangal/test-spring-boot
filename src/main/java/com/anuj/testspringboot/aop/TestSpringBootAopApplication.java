package com.anuj.testspringboot.aop;

import com.anuj.testspringboot.aop.nested.SpringAopService;
import com.anuj.testspringboot.aop.nested.sub.SpringAopService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestSpringBootAopApplication implements CommandLineRunner {

	@Autowired
	private SpringAopService springAopService;

	@Autowired
	private SpringAopService2 springAopService2;

	public static void main(String[] args) {
		try(ConfigurableApplicationContext applicationContext =
					SpringApplication.run(TestSpringBootAopApplication.class, args)) {
			//deliberately empty
		}
	}

	@Override
	public void run(String... args) throws Exception {
		this.springAopService.callMethod();
		this.springAopService2.callMethod();
	}
}
