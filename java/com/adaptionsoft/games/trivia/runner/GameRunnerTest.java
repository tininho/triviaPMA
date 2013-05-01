package com.adaptionsoft.games.trivia.runner;

import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.util.Checker;

public class GameRunnerTest {
	
	Checker checker;
	
	@Before
	public void initialization(){
		checker = new Checker();
		System.setOut(new PrintStream(checker));
	}
	
	@Test
	public void launchingWithNumberOfPlayers() {
		String[] args = {"6"};
		
		GameRunner.main(args);
		
		assertEquals(0L,checker.getChecksumValue());
	}
	
	@Test
	public void launchingWithNumberOfPlayersAndLanguage() {
		String[] args = {"6","ES"};
		
		GameRunner.main(args);
		
		assertEquals(0L,checker.getChecksumValue());
	}

}
