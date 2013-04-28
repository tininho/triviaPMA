package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class GameInspector extends Game {

	public GameInspector(int numberOfPlayers) {

		players = new ArrayList<String>(numberOfPlayers);
		places = new int[numberOfPlayers];
		purses = new int[numberOfPlayers];
		inPenaltyBox = new boolean[numberOfPlayers];

		popQuestions = new LinkedList();
		scienceQuestions = new LinkedList();
		sportsQuestions = new LinkedList();
		rockQuestions = new LinkedList();

		for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
		}
	}

}
