package com.adaptionsoft.games.util;

import java.util.MissingResourceException;


public class Printer {
	
	PropertiesSupplier supplier;
	
	public Printer(){
		supplier = new PropertiesSupplier();
	}
	
	public void printMessage(Object object) {
		try{
			System.out.println(supplier.obtainOneMessage(object.toString()));
		}catch(MissingResourceException e){
			System.out.println(object.toString());
		}
	}

	public void printMessage(Object ... object) {
		String message = "";
		for (int i = 0; i < object.length; i++) {
			try{
				if (i==0)
					message=supplier.obtainOneMessage(object[i].toString());
				else
					message = message + " " + supplier.obtainOneMessage(object[i].toString());
			}catch(MissingResourceException e){
				if (i==0)
					message=object[i].toString();
				else
					message = message + " " + object[i].toString();
			}
		}
		System.out.println(message);
	}

}
