package com.adaptionsoft.games.util;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

public class PropertiesSupplierTest {

	@Test
	public void obtainOnePropertyMessage() {
		PropertiesSupplier supplier = new PropertiesSupplier();
		String result = supplier.obtainOneMessage("added");
		assertEquals(" was added", result);
	}
	
	@Test
	public void obtainOnePropertyMessageByLanguage(){
		PropertiesSupplier supplier = new PropertiesSupplier();
		String result = supplier.obtainOneMessageByLanguage("added", new Locale("ES"));
		assertEquals(" fue incluido", result);
	}

}
