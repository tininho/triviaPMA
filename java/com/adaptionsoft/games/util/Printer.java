package com.adaptionsoft.games.util;


public class Printer {
	
	public void printMessage(Object object) {
		System.out.println(object.toString());
	}

	public void printMessage(Object ... object) {
		String message = "";
		for (int i = 0; i < object.length; i++) {
			message+=object[i].toString();
		}
		System.out.println(message);
	}

}
