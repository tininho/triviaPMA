package com.adaptionsoft.games.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesSupplier {

	ResourceBundle resourceBundle;
	
	public PropertiesSupplier(){
		resourceBundle = ResourceBundle.getBundle("localBundle");
	}
	
	public String obtainOneMessage(String key) {
		return resourceBundle.getString(key);
	}

	public String obtainOneMessageByLanguage(String key, Locale locale) {
		resourceBundle = ResourceBundle.getBundle("localBundle", locale);
		return resourceBundle.getString(key);
	}

}
