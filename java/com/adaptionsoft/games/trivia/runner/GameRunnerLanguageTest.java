package com.adaptionsoft.games.trivia.runner;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.util.Checker;

public class GameRunnerLanguageTest {

	Checker checker;
	
	@Before
	public void initialization(){
		checker = new Checker();
		System.setOut(new PrintStream(checker));
	}

	@Test
	public void gameRunnerCharacterizationBySpanishLanguage() {
		// given
		Game aGame = GameRunner.init(6, new Locale("ES"));
		Random random = new Random(0L);

		// check
		GameRunner.run(aGame, random);

		// verify
		assertEquals(3078521546L, checker.getChecksumValue());
	}

}
