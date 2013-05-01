package com.adaptionsoft.games.trivia.runner;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.util.Checker;

public class GameRunnerInspectorTest {

    Checker checker;
    GameRunnerInspector runnerInspector;
	
	@Before
	public void initialization(){
		runnerInspector = new GameRunnerInspector();
		checker = new Checker();
		System.setOut(new PrintStream(checker));
	}

	@Test
	public void gameRunnerCharacterizationBySpanishLanguage() {
		// given
		Game aGame = GameRunnerInspector.init(6, new Locale("ES"));
		Random random = new Random(0L);

		// check
		GameRunner.run(aGame, random);

		// verify
		assertEquals(1820951815L, checker.getChecksumValue());
	}

}
