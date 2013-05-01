package com.adaptionsoft.games.util;

import java.util.Locale;
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
				message = message + supplier.obtainOneMessage(object[i].toString());
			}catch(MissingResourceException e){
				message = message + object[i].toString();
			}
		}
		System.out.println(message);
	}

	public void printMessageByLanguage(Locale locale, Object object) {
		try{
			System.out.println(supplier.obtainOneMessageByLanguage(object.toString(), locale));
		}catch(MissingResourceException e){
			System.out.println(object.toString());
		}
	}

	public void printMessageByLanguage(Locale locale, Object ... object) {
		String message = "";
		for (int i = 0; i < object.length; i++) {
			try{
				message = message + supplier.obtainOneMessageByLanguage(object[i].toString(), locale);
			}catch(MissingResourceException e){
				message = message + object[i].toString();
			}
		}
		System.out.println(message);
	}

}
