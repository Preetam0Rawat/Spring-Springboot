package com.in28minutes.learn_spring_framework.examples.g1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named // jakarata EE Annotation
class BusinessService {
	private DataService dataService;

	// @Autowired
	@Inject // jakarata EE Annotation
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}

	public DataService getDataService() {
		return dataService;
	}

}


@Named          //jakarata EE Annotation
//@Component
class DataService {

}

@Configuration
@ComponentScan // If no package is mentioned then scanning will be done in current package
public class CdiContextLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {

			System.out.println(context.getBean(BusinessService.class).getDataService());

		}

	}

}
