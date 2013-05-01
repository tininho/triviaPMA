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
		
		assertTrue(checker.getChecksumValue()>1000000L);
	}
	
	@Test
	public void launchingWithNumberOfPlayersAndLanguage() {
		String[] args = {"6","ES"};
		
		GameRunner.main(args);
		
		assertTrue(checker.getChecksumValue()>1000000L);
	}

}
