package com.adaptionsoft.games.trivia.runner;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;

public class GameRunnerTest {
	
    class Checker extends OutputStream{
		
		Checksum checksum = new CRC32();
		
		@Override
		public void write(int b) throws IOException{
			checksum.update(b);
		}
	}
	
	@Test
	public void gameRunnerCharacterization(){
		// given
		Checker checker = new Checker();
		System.setOut(new PrintStream(checker));
		Game aGame = GameRunner.init();
		Random random = new Random(0L);
		
		// check
		GameRunner.run(aGame, random);
		
		// verify
		assertEquals(2233795382L, checker.checksum.getValue());
	}

}
