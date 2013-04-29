package com.adaptionsoft.games.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class PropertiesSupplierTest {

	@Test
	public void obtainOnePropertyMessage() {
		PropertiesSupplier supplier = new PropertiesSupplier();
		String result = supplier.obtainOneMessage();
		assertEquals("HelloWorld", result);
	}

}
