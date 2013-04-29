package com.adaptionsoft.games.util;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class PrinterTest {

	Checker checker;
	
	@Before
	public void initialization(){
		checker = new Checker();
		System.setOut(new PrintStream(checker));
	}
	
	@Test
	public void shouldPrintOneMessage(){
		Printer printer = new Printer();
		printer.printMessage(0L );
		assertEquals(2387717073L,checker.getChecksumValue());
	}
	
	@Test
	public void shouldPrintAnyNumberOfObjects(){
		Printer printer = new Printer();
		printer.printMessage("HelloWorld", 5, 0L, "que tal", "patatin", 67);
		assertEquals(3787434164L,checker.getChecksumValue());
	}
	
}
