package com.adaptionsoft.games.trivia.runner;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.Random;

import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.util.Checker;

public class GameRunnerTest {
	
	@Test
	public void gameRunnerCharacterization(){
		// given
		Checker checker = new Checker();
		System.setOut(new PrintStream(checker));
		Game aGame = GameRunner.init();
		Random random = new Random(0L);
		
		// check
		GameRunner.run(aGame, random);
		
		// verify
		assertEquals(2233795382L, checker.getChecksumValue());
	}

}
