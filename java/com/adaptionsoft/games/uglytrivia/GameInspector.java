package com.adaptionsoft.games.uglytrivia;

import java.util.Locale;

import com.adaptionsoft.games.util.Printer;

public class GameInspector extends Game {

	Printer printer;
	Locale locale;

	public GameInspector(int numberOfPlayers) {
		super(numberOfPlayers);
		printer = new Printer();
	}

	public GameInspector(int numberOfPlayers, Locale locale) {
		this(numberOfPlayers);
		this.locale = locale;
	}

	@Override
	public boolean add(String playerName) {

		players.add(playerName);

		printer.printMessage(playerName, "added");
		printer.printMessage("playernumber", players.size());
		return true;
	}

	public boolean addByLanguage(String playerName) {

		players.add(playerName);

		printer.printMessageByLanguage(locale, playerName, "added");
		printer.printMessageByLanguage(locale, "playernumber", players.size());
		return true;
	}

}
