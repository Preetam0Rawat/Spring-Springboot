package com.in28minutes.learn_spring_framework;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import com.in28minutes.learn_spring_framework.game.PacmanGame;

@Configuration
public class GamingConfiguration {
	
	@Bean
	public GamingConsole game() {
		var game = new PacmanGame();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner  = new GameRunner(game); 
		return gameRunner;
	}
	
	
//	public static void main(String[] args) {		
//		var game  = new MarioGame();
//		var game  = new PacmanGame();                //object creation
//		var gameRunner  = new GameRunner(game);      // object creation  + wiring of dependencies
//                                                     // Game(of GamingConsle) is a dependency of GameRunner   
//		gameRunner.run();

}
