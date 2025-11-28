package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age, Address address) {};
record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
    @Bean 
	public String name() {
    	 return "Ranga";
     }
    
    @Bean 
	public int age() {
    	 return 15;
    }
    
    //Hard coded
    @Bean  
    public Person person() {            
    	return new Person("Ravi" ,20, new Address("Main Street" , "Utrecht"));
    } 
    
    //Using beans  / Auto-wiring using method call
    @Bean 
    public Person person2MethodCall() {   
    	return new Person( name(), age(), address());    //name , age
    } 
    
    //Using parameters /  Auto-wiring using parameters
    @Bean 
    public Person person3Parameters(String name, int age, Address address2) {   
    	return new Person( name, age, address2);    //name , age
    } 
    
    @Bean (name = "address2")
    public Address address() {
         return new Address("Baker Street" , "London");
    }
}
