package com.adaptionsoft.games.util;

public class Printer {

	public void printMessage(Object object1, Object object2) {
		System.out.println(object1.toString() + object2.toString());
	}

	public void printMessage(Object object) {
		System.out.println(object.toString());
	}

}
