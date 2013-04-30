package com.adaptionsoft.games.uglytrivia;

import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.util.Checker;

public class GameInspectorTest {

	Game aGame;
	Checker checker;
	
	@Before
	public void initilization(){
		aGame = new GameInspector(6);
		checker = new Checker();
		//System.setOut(new PrintStream(checker));
	}
	
	@Test
	public void printMessageAddingPlayers() {
		aGame.add("Romina");
		//assertEquals(535739654L, checker.getChecksumValue());
	}

}
