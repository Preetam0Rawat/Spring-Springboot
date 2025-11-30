package com.in28minutes.learn_spring_framework.examples.d1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;



@Component
class ClassA{
	

}

@Component
@Lazy            //Lazy initialization - load bean only when class is called
class ClassB{
 private ClassA classA;	
	
 public ClassB(ClassA classA) {	
	 System.out.println("Some initialization logic");
  this.classA = classA;
  
 }
 
 public void doSomething() {
	 System.out.println("Do something");
 }
}



@Configuration
@ComponentScan  //If no package is mentioned then scanning will be done in current package
public class LazyInitializationLauncherApplication {

	
	
	
	
	public static void main(String[] args) {
		
		try(var context =  new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
					
			System.out.println("Initilaizatoin of context is done");
			context.getBean(ClassB.class).doSomething();
		}

	

	}
 
}
