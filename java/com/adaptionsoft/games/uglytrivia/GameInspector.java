package com.adaptionsoft.games.uglytrivia;

public class GameInspector extends Game{

	public GameInspector(int numberOfPlayers) {
		super(numberOfPlayers);
	}

	@Override
    public boolean add(String playerName) {
		
	    players.add(playerName);
	    
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}
	
}
