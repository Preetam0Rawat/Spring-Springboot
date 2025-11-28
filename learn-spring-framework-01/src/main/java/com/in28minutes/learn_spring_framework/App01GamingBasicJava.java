package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
//import com.in28minutes.learn_spring_framework.game.MarioGame;
import com.in28minutes.learn_spring_framework.game.PacmanGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {		
//		var game  = new MarioGame();
		var game  = new PacmanGame();                //object creation
		var gameRunner  = new GameRunner(game);      // object creation  + wiring of dependencies
                                                     // Game(of GamingConsle) is a dependency of GameRunner   
		gameRunner.run();

	}

}
