package com.adaptionsoft.games.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PrinterTest {

	@Test
	public void shouldPrintATextMessage(){
		Printer printer = new Printer();
		assertEquals("HelloWorld",printer.printMessage());
	}
	
}
