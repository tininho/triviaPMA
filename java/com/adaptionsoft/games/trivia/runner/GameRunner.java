package com.adaptionsoft.games.trivia.runner;

import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;

public class GameRunner {

	private static boolean notAWinner;
	
	private static int DEFAULT_NUMBER_OF_PLAYERS = 6;
	
	private static String EMPTY_STRING = "";
	
	public static void main(String[] args) {
		int numberOfPlayers = DEFAULT_NUMBER_OF_PLAYERS;
		
		if (args[0]!=null && ! EMPTY_STRING.equals(args[0]))
			numberOfPlayers = Integer.valueOf(args[0]);
		
		Game aGame = init(numberOfPlayers);

		Random rand = new Random();

		run(aGame, rand);

	}
	
	static Game init(int numberOfPlayers) {
		Game aGame = new Game(numberOfPlayers);
		
		for (int i = 0; i < numberOfPlayers; i++) {
			aGame.add("Player "+(i+1));
		}
		
		return aGame;
	}

	static Game init() {
		Game aGame = new Game();
		
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
		
		return aGame;
	}
	
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
