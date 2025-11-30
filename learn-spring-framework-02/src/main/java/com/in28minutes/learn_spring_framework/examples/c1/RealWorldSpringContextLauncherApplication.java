package com.in28minutes.learn_spring_framework.examples.c1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan  //If no package is mentioned then scanning will be done in current package
public class RealWorldSpringContextLauncherApplication {

	
	
	
	
	
	public static void main(String[] args) {
		
		try(var context =  new AnnotationConfigApplicationContext(RealWorldSpringContextLauncherApplication.class)) {
		
			System.out.println(	context.getBean(BusinessCalculationService.class).findMax());
		}

	

	}
 
}
