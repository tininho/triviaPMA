package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;

public class GameRunnerInspector{
	
	static Game sixPlayersinit() {
		Game aGame = new Game();
		
		aGame.add("Oriol");
		aGame.add("Toni");
		aGame.add("Jordi");
		aGame.add("Sandra");
		aGame.add("Aida");
		aGame.add("Arthur");
		
		return aGame;
	}
	
}
