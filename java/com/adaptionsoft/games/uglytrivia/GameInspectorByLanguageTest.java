package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.util.Checker;

public class GameInspectorByLanguageTest {

	GameInspector aGame;
	Checker checker;
	
	@Before
	public void initilization(){
		aGame = new GameInspector(6,new Locale("ES"));
		checker = new Checker();
		System.setOut(new PrintStream(checker));
	}
	
	@Test
	public void printMessageAddingPlayersBySpanishLanguage() {
		aGame.addByLanguage("Romina");
		assertEquals(535739654L, checker.getChecksumValue());
	}

}
