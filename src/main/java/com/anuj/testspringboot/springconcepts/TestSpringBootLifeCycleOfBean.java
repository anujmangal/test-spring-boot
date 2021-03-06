package com.anuj.testspringboot.springconcepts;

import com.anuj.testspringboot.SomeRandomComponent;
import com.anuj.testspringboot.SomeRandomPrototypeComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

//somehow spring boot only picks up files names like application.properties and app.properties but not external.properties
@SpringBootApplication
@PropertySource("classpath:app.properties")
public class TestSpringBootLifeCycleOfBean {

	@Autowired
	private LifeCycleOfBean lifeCycleOfBean;

	public LifeCycleOfBean getLifeCycleOfBean() {
		return lifeCycleOfBean;
	}

	public void setLifeCycleOfBean(LifeCycleOfBean lifeCycleOfBean) {
		this.lifeCycleOfBean = lifeCycleOfBean;
	}

	public static void main(String[] args) {

		try(ConfigurableApplicationContext applicationContext =
					SpringApplication.run(TestSpringBootLifeCycleOfBean.class, args)) {

			//Testing Singleton Bean (default Spring)
			//The object is same (has same hashcode)for a singleton bean
			TestSpringBootLifeCycleOfBean testSpringBootLifeCycleOfBean =
					applicationContext.getBean(TestSpringBootLifeCycleOfBean.class);
			System.out.println(testSpringBootLifeCycleOfBean.getLifeCycleOfBean());

			ReadingExternalPropertiesFile readingExternalPropertiesFile =
					applicationContext.getBean(ReadingExternalPropertiesFile.class);
			System.out.println(readingExternalPropertiesFile.readDataFromExternalProperties());
		}
	}

}
