package com.adaptionsoft.games.util;

public class Printer {

	public void printMessage() {
		System.out.println("HelloWorld");
	}

	public void printMessage(Object object, String string) {
		System.out.println(object.toString() + string);
	}

}
