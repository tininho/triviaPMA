package com.adaptionsoft.games.util;

import java.util.ResourceBundle;

public class PropertiesSupplier {

	ResourceBundle resourceBundle;
	
	public PropertiesSupplier(){
		resourceBundle = ResourceBundle.getBundle("localBundle");
	}
	
	public String obtainOneMessage(String key) {
		return resourceBundle.getString(key);
	}

}
