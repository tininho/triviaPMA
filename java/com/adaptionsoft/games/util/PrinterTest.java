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
	public void shouldPrintATextMessage(){
		Printer printer = new Printer();
		printer.printMessage();
		assertEquals(3823729743L,checker.getChecksumValue());
	}
	
}