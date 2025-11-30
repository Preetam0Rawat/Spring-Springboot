package com.in28minutes.learn_spring_framework.examples.f1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private SomeDependency someDependency;

	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All dependency are ready");
	}

	@PostConstruct // A code that needs to be runs right after wiring
	public void initialize() {
		SomeDependency.getReady();
	}

	@PreDestroy // A code that need to be run just before a bean is destroyed
	public void cleanUp() {
		System.out.println("Cleanup");
	}
}

@Component
class SomeDependency {

	public static void getReady() {
		System.out.println("Somelogic using some dependecy");

	}

}

@Configuration
@ComponentScan // If no package is mentioned then scanning will be done in current package
public class PrePostAnnotationContextLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class)) {

		}

	}

}
