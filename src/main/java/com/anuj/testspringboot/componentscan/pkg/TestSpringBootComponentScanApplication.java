package com.anuj.testspringboot.componentscan.pkg;

import com.anuj.testspringboot.SomeRandomPrototypeComponent;
import com.anuj.testspringboot.componentscan.TestComponentScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//Spring Boot Application by default scans for the component in the current directory and all the
//subdirectories within the current directory, it doesn;t scan any sibling directory of th current directory
//or any directory present at a higher hierarchy. So for telling Spring to scan these packages , we can provide
//component scan locations
@SpringBootApplication
@ComponentScan("com.anuj.testspringboot.componentscan")
public class TestSpringBootComponentScanApplication {

	@Autowired
	private TestComponentScanService TestComponentScanService;

	public TestComponentScanService getTestComponentScanService() {
		return TestComponentScanService;
	}

	public void setTestComponentScanService(TestComponentScanService testComponentScanService) {
		TestComponentScanService = testComponentScanService;
	}

	public static void main(String[] args) {

		try(ConfigurableApplicationContext applicationContext =
					SpringApplication.run(TestSpringBootComponentScanApplication.class, args)) {

			TestSpringBootComponentScanApplication testSpringBootComponentScanApplication =
					applicationContext.getBean(TestSpringBootComponentScanApplication.class);

			System.out.println(testSpringBootComponentScanApplication.getTestComponentScanService());

		}
	}

}
