package com.anuj.testspringboot;

import com.anuj.testspringboot.dependencies.TestSingletonClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.xml.bind.SchemaOutputResolver;

@SpringBootApplication
public class TestSpringBootApplication {

	public static void main(String[] args) {

		try(ConfigurableApplicationContext applicationContext =
					SpringApplication.run(TestSpringBootApplication.class, args)) {

			//Testing Singleton Bean (default Spring)
			//The object is same (has same hashcode)for a singleton bean
			SomeRandomComponent someRandomComponent =
					applicationContext.getBean(SomeRandomComponent.class);
			SomeRandomComponent someRandomComponent2 =
					applicationContext.getBean(SomeRandomComponent.class);
			System.out.println(someRandomComponent);
			System.out.println(someRandomComponent2);

			//Testing Prototype Bean. The object is different for each getBean from AppContext
			// (has different hashcode)for a prototype bean
			SomeRandomPrototypeComponent someRandomPrototypeComponent
					= applicationContext.getBean(SomeRandomPrototypeComponent.class);
			SomeRandomPrototypeComponent someRandomPrototypeComponent2
					= applicationContext.getBean(SomeRandomPrototypeComponent.class);
			System.out.println(someRandomPrototypeComponent);
			System.out.println(someRandomPrototypeComponent2);

		}
	}

}
