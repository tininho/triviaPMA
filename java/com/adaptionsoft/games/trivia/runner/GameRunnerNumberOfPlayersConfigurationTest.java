package com.adaptionsoft.games.trivia.runner;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.Random;

import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.util.Checker;

public class GameRunnerNumberOfPlayersConfigurationTest {

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

	@Test(expected = Exception.class)
	public void gameRunnerCharacterizationSevenPlayers() {
		// given
		Checker checker = new Checker();
		System.setOut(new PrintStream(checker));
		Game aGame = GameRunnerInspector.sevenPlayersInit();
		Random random = new Random(0L);

		// check
		GameRunner.run(aGame, random);

		// fail
		fail("Exception not throw");
	}

	@Test
	public void gameRunnerCharacterizationFourPlayers() {
		// given
		Checker checker = new Checker();
		System.setOut(new PrintStream(checker));
		Game aGame = GameRunnerInspector.fourPlayersInit();
		Random random = new Random(0L);

		// check
		GameRunner.run(aGame, random);

		// verify
		assertEquals(1826728610L, checker.getChecksumValue());
	}

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