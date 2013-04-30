package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.util.Printer;

public class GameInspector extends Game{

	Printer printer;
	
	public GameInspector(int numberOfPlayers) {
		super(numberOfPlayers);
		printer = new Printer();
	}

	@Override
    public boolean add(String playerName) {
		
	    players.add(playerName);
	    
	    printer.printMessage(playerName, "added");
	    printer.printMessage("playernumber", players.size());
		return true;
	}
	
}
