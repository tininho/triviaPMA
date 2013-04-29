package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameConfiguration {

	private List<Integer> validNumberOfPlayers;
	
	public GameConfiguration(){
		validNumberOfPlayers = new ArrayList<Integer>(Arrays.asList(2,4,6));
	}
	
    public boolean isNotAnAllowedConfiguration(int numberOfPlayers){
    	return ! validNumberOfPlayers.contains(numberOfPlayers);
    }
	
}
