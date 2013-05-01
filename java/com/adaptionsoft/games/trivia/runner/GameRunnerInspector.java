package com.adaptionsoft.games.trivia.runner;

import java.util.Locale;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.GameInspector;

public class GameRunnerInspector extends GameRunner{

	public static Game init(int numberOfPlayers, Locale locale) {
        Game aGame = new GameInspector(numberOfPlayers, locale);
		
		for (int i = 0; i < numberOfPlayers; i++) {
			aGame.add("Player"+(i+1));
		}
		
		return aGame;
	}

}
