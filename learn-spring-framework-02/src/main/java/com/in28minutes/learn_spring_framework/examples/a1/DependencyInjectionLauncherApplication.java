package com.in28minutes.learn_spring_framework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {

//	@Autowired                //Field Injection
//	Dependency1 dependency1;  // 'dependency1' is not an object but a reference to object created by spring
//	@Autowired 
//	Dependency2 dependency2;
//	
//	

	Dependency1 dependency1; // Note: null, cause not auto-wired
	Dependency2 dependency2;

	@Autowired                //Not necessary in case of primary constructor
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {   // Constructor Injection
		super();
		System.out.println("Constructor Injection - YourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

//	
//	@Autowired 
//	public void setDependency1(Dependency1 dependency1) {         //Setter Injection
//		System.out.println("Setter Injection - setDependency1");
//		this.dependency1 = dependency1;
//	}
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {         //Setter Injection
//		System.out.println("Setter Injection - setDependency2");
//		this.dependency2 = dependency2;
//	}
//

	public String toString() {
		return "Using" + dependency1 + "and" + dependency2;
	}
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan // If no package is mentioned then scanning will be done in current package
public class DependencyInjectionLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class)) {
			System.out.println(context.getBean(YourBusinessClass.class));
		}

	}

}
