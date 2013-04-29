package com.adaptionsoft.games.trivia.runner;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.Random;

import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.util.Checker;

public class GameRunnerNumberOfPlayersConfigurationTest {

	@Test
	public void gameRunnerCharacterizationOnlySixPlayers() {
		// given
		Checker checker = new Checker();
		System.setOut(new PrintStream(checker));
		Game aGame = GameRunner.init(6);
		Random random = new Random(0L);

		// check
		GameRunner.run(aGame, random);

		// verify
		assertEquals(3069541038L, checker.getChecksumValue());
	}

	@Test
	public void gameRunnerCharacterizationOnlyFourPlayers() {
		// given
		Checker checker = new Checker();
		System.setOut(new PrintStream(checker));
		Game aGame = GameRunner.init(4);
		Random random = new Random(0L);

		// check
		GameRunner.run(aGame, random);

		// verify
		assertEquals(346077682L, checker.getChecksumValue());
	}

	@Test
	public void gameRunnerCharacterizationOnlyTwoPlayers() {
		// given
		Checker checker = new Checker();
		System.setOut(new PrintStream(checker));
		Game aGame = GameRunner.init(2);
		Random random = new Random(0L);

		// check
		GameRunner.run(aGame, random);

		// verify
		assertEquals(3433267896L, checker.getChecksumValue());
	}

}
