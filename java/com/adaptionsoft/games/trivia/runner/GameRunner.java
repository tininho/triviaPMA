package com.adaptionsoft.games.trivia.runner;

import java.util.Locale;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;

public class GameRunner {

	private static boolean notAWinner;
	
	private static int DEFAULT_NUMBER_OF_PLAYERS = 6;
	
	private static String EMPTY_STRING = "";
	
	public static void main(String[] args) {
		int numberOfPlayers = DEFAULT_NUMBER_OF_PLAYERS;
		Locale locale = null;
		Game aGame;
		
		if (args.length==1){
			if (args[0]!=null && ! EMPTY_STRING.equals(args[0]))
				numberOfPlayers = Integer.valueOf(args[0]);
		}
		if (args.length==2){
			if (args[1]!=null && ! EMPTY_STRING.equals(args[1]))
				locale = new Locale(args[1]);
		}
		
		if (locale!=null)
			aGame = init(numberOfPlayers, locale);
		else
			aGame = init(numberOfPlayers);
		
		Random rand = new Random();

		run(aGame, rand);

	}
	
	static Game init(int numberOfPlayers) {
		Game aGame = new Game(numberOfPlayers);
		
		for (int i = 0; i < numberOfPlayers; i++) {
			aGame.add("Player"+(i+1));
		}
		
		return aGame;
	}
	
	public static Game init(int numberOfPlayers, Locale locale) {
        Game aGame = new Game(numberOfPlayers, locale);
		
		for (int i = 0; i < numberOfPlayers; i++) {
			aGame.add("Player"+(i+1));
		}
		
		return aGame;
	}

	static void run(Game aGame, Random rand) {
		do {

			aGame.roll(rand.nextInt(5) + 1);

			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}

		} while (notAWinner);
	}

}
