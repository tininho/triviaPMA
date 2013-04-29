package com.adaptionsoft.games.util;

import java.util.Iterator;

public class Printer {

	public void printMessage(Object object1, Object object2) {
		System.out.println(object1.toString() + object2.toString());
	}

	public void printMessage(Object object) {
		System.out.println(object.toString());
	}

	public void printMessage(Object object1, Object object2, Object object3) {
		System.out.println(object1.toString() + object2.toString() + object3.toString());
	}

	public void printMessage(Object ... object) {
		String message = "";
		for (int i = 0; i < object.length; i++) {
			message+=object.toString();
		}
		System.out.println(message);
	}

}
