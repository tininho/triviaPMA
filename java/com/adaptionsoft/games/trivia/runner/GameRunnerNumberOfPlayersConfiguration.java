package com.adaptionsoft.games.trivia.runner;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.Random;

import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.util.Checker;

public class GameRunnerNumberOfPlayersConfiguration {

	@Test
	public void gameRunnerCharacterizationSixPlayers() {
		// given
		Checker checker = new Checker();
		System.setOut(new PrintStream(checker));
		Game aGame = GameRunner.sixPlayersinit();
		Random random = new Random(0L);

		// check
		GameRunner.run(aGame, random);

		// verify
		assertEquals(1834776121L, checker.getChecksumValue());
	}
	
	@Test
	public void gameRunnerCharacterizationSevenPlayers() {
		fail("not yet implemented");
	}

}
