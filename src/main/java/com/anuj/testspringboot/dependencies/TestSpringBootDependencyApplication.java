package com.anuj.testspringboot.dependencies;

import com.anuj.testspringboot.SomeRandomComponent;
import com.anuj.testspringboot.SomeRandomPrototypeComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestSpringBootDependencyApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(TestSpringBootDependencyApplication.class, args);

		//How to get different object each time for a dependency of a Singleton bean
		//Lets see? A has B where A is singleton and B is prototype without any special parameters to annotation
		TestSingletonClass testSingletonClass1 = applicationContext.getBean(TestSingletonClass.class);
		System.out.println("SingleTon Class Instance 1 -> " + testSingletonClass1);
		System.out.println("Default Prototype Service Class -> " + testSingletonClass1.getDefaultPrototypeService());
		System.out.println("Actual Prototype Service Class -> " + testSingletonClass1.getActualPrototypeService());

		TestSingletonClass testSingletonClass2 = applicationContext.getBean(TestSingletonClass.class);
		System.out.println("SingleTon Class Instance 2 -> " + testSingletonClass2);
		System.out.println("Default Prototype Service Class -> " + testSingletonClass2.getDefaultPrototypeService());
		System.out.println("Actual Prototype Service Class -> " + testSingletonClass2.getActualPrototypeService());

		//Actual Prototype Class uses proxy which returns a different object each time while default prototype doesn't use proxy,
		//so even when it is declared prototype ion a singleton bean, it still uses the same object
	}

}
