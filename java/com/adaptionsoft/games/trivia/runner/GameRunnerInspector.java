package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.GameInspector;

public class GameRunnerInspector{
	
	static Game sixPlayersInit() {
		Game aGame = new Game();
		
		aGame.add("Oriol");
		aGame.add("Toni");
		aGame.add("Jordi");
		aGame.add("Sandra");
		aGame.add("Aida");
		aGame.add("Arthur");
		
		return aGame;
	}
	
	static Game sevenPlayersInit() {
		Game aGame = new Game();
		
		aGame.add("Oriol");
		aGame.add("Toni");
		aGame.add("Jordi");
		aGame.add("Sandra");
		aGame.add("Aida");
		aGame.add("Arthur");
		aGame.add("Tino");
		
		return aGame;
	}
	
	static Game fourPlayersInit() {
		Game aGame = new Game();
		
		aGame.add("Oriol");
		aGame.add("Toni");
		aGame.add("Jordi");
		aGame.add("Sandra");

		
		return aGame;
	}
	
	static Game onlySixPlayersInit(){
		Game aGame = new GameInspector(6);
		
		aGame.add("Oriol");
		aGame.add("Toni");
		aGame.add("Jordi");
		aGame.add("Sandra");
		aGame.add("Aida");
		aGame.add("Arthur");
		
		return aGame;
	}
	
	static Game onlyFourPlayersInit(){
		Game aGame = new GameInspector(4);
		
		aGame.add("Oriol");
		aGame.add("Toni");
		aGame.add("Jordi");
		aGame.add("Sandra");
		
		return aGame;
	}
	
}
