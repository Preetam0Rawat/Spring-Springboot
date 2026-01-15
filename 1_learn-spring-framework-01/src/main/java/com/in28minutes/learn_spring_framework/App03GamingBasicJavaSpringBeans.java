package com.in28minutes.learn_spring_framework;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;



public class App03GamingBasicJavaSpringBeans {

	public static void main(String[] args) {
		
		try(var context =  new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
					context.getBean(GamingConsole.class).up();	
			        context.getBean(GameRunner.class).run();
		}

		
//		var game  = new MarioGame();
//		var game  = new PacmanGame();                //object creation
//		var gameRunner  = new GameRunner(game);      // object creation  + wiring of dependencies
//                                                     // Game(of GamingConsle) is a dependency of GameRunner   
//		gameRunner.run();

	}
 
}
