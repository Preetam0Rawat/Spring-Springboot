package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {		
        //1: Launch a Spring context
		
		try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
			
			 //2: Configure the things that we want Spring to manage -@Configuration
		    //name - @Bean
			
			//3: Retrieving Beans managed by spring
			  // System.out.println(  context.getBean("name"));
			  // System.out.println(  context.getBean("person"));
			  // System.out.println(  context.getBean(Address.class));
			  // System.out.println( context.getBean("person2MethodCall"));
			     System.out.println( context.getBean("person3Parameters"));
		}
       
		   
	}

}
