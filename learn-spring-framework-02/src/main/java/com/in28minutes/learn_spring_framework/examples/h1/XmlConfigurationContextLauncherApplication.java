package com.in28minutes.learn_spring_framework.examples.h1;

//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Configuration
//@ComponentScan // If no package is mentioned then scanning will be done in current package
public class XmlConfigurationContextLauncherApplication {

	public static void main(String[] args) {
		
		try(var context =  
//				new AnnotationConfigApplicationContext                         using java configuration
//			    (XmlConfigurationContextLauncherApplication.class)) {}
				
				new ClassPathXmlApplicationContext("contextConfiguration.xml")) {  //using xml cconfiguration (before java configuration came)
               	
			System.out.println(context.getBean("name"));
             	}
     }
}