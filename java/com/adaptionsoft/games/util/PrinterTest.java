package com.adaptionsoft.games.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
		fail("not yet implemented");
	}
	
	@Test
	public void shouldPrintTwoObjectsConcat(){
		Printer printer = new Printer();
		printer.printMessage("HelloWorld", 5 );
		assertEquals(2976813313L,checker.getChecksumValue());
	}
	
}
