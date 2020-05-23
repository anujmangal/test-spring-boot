package com.anuj.testspringboot.sameinterfacedependency;

import com.anuj.testspringboot.SomeRandomComponent;
import com.anuj.testspringboot.SomeRandomPrototypeComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestSpringBootSameInterfaceDependencyApplication {

	@Autowired
	private TestInterface testInterface;

	@Autowired
	@Qualifier("qualifier")
	private TestQualifierInterface testQualifierInterface;

	@Autowired
	private TestInterfaceAutowiringByName testInterfaceAutowiringByName1Dependency;

	@Autowired
	private TestInterfaceAutowiringByName testInterfaceAutowiringByName2Dependency;

	public TestInterface getTestInterface() {
		return testInterface;
	}

	public void setTestInterface(TestInterface testInterface) {
		this.testInterface = testInterface;
	}

	public TestQualifierInterface getTestQualifierInterface() {
		return testQualifierInterface;
	}

	public void setTestQualifierInterface(TestQualifierInterface testQualifierInterface) {
		this.testQualifierInterface = testQualifierInterface;
	}

	public TestInterfaceAutowiringByName getTestInterfaceAutowiringByName1Dependency() {
		return testInterfaceAutowiringByName1Dependency;
	}

	public void setTestInterfaceAutowiringByName1Dependency(TestInterfaceAutowiringByName testInterfaceAutowiringByName1Dependency) {
		this.testInterfaceAutowiringByName1Dependency = testInterfaceAutowiringByName1Dependency;
	}

	public TestInterfaceAutowiringByName getTestInterfaceAutowiringByName2Dependency() {
		return testInterfaceAutowiringByName2Dependency;
	}

	public void setTestInterfaceAutowiringByName2Dependency(TestInterfaceAutowiringByName testInterfaceAutowiringByName2Dependency) {
		this.testInterfaceAutowiringByName2Dependency = testInterfaceAutowiringByName2Dependency;
	}

	public static void main(String[] args) {

		try(ConfigurableApplicationContext applicationContext =
					SpringApplication.run(TestSpringBootSameInterfaceDependencyApplication.class, args)) {

			TestSpringBootSameInterfaceDependencyApplication testingTestInterface =
					applicationContext.getBean(TestSpringBootSameInterfaceDependencyApplication.class);

			// If we don't add primary to any bean, spring context fails to initialize as it can not determine which bean to choose
			// if we add primary, that bean is chosen (highest priority)
			System.out.println(testingTestInterface.getTestInterface());

			//If we add Qualifier to one or dependency, then we can use that qualifier to autowire the dependency.
			//If we don;t use qualifier and we do not have primary annotation on the bean, then again spring context
			//will fail to find the bean
			System.out.println(testingTestInterface.getTestQualifierInterface());


			//we can also autowire the name by dependency but it should be least preferred, usually qualifier and primary
			//annotation should achieve what you are trying to do.
			//Also, if you try to autowire but have a primary annotation declared on a bean, then primary annotation will take
			//precedence in that case
			System.out.println(testingTestInterface.getTestInterfaceAutowiringByName1Dependency());
			System.out.println(testingTestInterface.getTestInterfaceAutowiringByName2Dependency());
		}
	}
}
