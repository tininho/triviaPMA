package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.util.Checker;

public class GameTest {

	Game aGame;
	Checker checker;
	
	@Before
	public void initilization(){
		aGame = new Game(6);
		checker = new Checker();
		System.setOut(new PrintStream(checker));
	}
	
	@Test
	public void printMessageAddingPlayers() {
		aGame.add("Romina");
		assertEquals(535739654L, checker.getChecksumValue());
	}

}
