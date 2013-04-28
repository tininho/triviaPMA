
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		Game aGame = new Game();
		
		init(aGame);
		
		Random rand = new Random();
	
		run(aGame, rand);
		
	}
	
	protected static void init(Game aGame) {
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
	}

	protected static void run(Game aGame, Random rand) {
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
