package com.in28minutes.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SupercontraGameQualifier")
public class SupercontraGame implements GamingConsole {

	 public void up() {
		 System.out.println("Up");
	 }
	 
	 public void down() {
		 System.out.println("Sit Down");
	 }
	 
	 public void left() {
		 System.out.println("Go back");
	 }
	 
	 public void right() {
		 System.out.println("Shoot a bullet");
	 }
	 
	
}
