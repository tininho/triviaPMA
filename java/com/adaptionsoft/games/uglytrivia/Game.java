package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

import com.adaptionsoft.games.util.Printer;


public class Game {
    ArrayList<String> players;
    int[] places;
    int[] purses;
    boolean[] inPenaltyBox;

    LinkedList<String> popQuestions;
    LinkedList<String> scienceQuestions;
    LinkedList<String> sportsQuestions;
    LinkedList<String> rockQuestions;
    
    GameConfiguration gameConfiguration;
    Printer printer;
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
    
    public Game(int numberOfPlayers) {
    	
    	gameConfiguration = new GameConfiguration();
    	printer = new Printer();
    	
    	if (gameConfiguration.isNotAnAllowedConfiguration(numberOfPlayers)){
    		printer.printMessage("confallowed");
    		System.exit(0);
    	}

		players = new ArrayList<String>(numberOfPlayers);
		places = new int[numberOfPlayers];
		purses = new int[numberOfPlayers];
		inPenaltyBox = new boolean[numberOfPlayers];

		popQuestions = new LinkedList<String>();
		scienceQuestions = new LinkedList<String>();
		sportsQuestions = new LinkedList<String>();
		rockQuestions = new LinkedList<String>();

		for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(("Rock Question " + i));
		}
	}

	public boolean add(String playerName) {
		
	    players.add(playerName);
	    
	    printer.printMessage(playerName,"added");
	    printer.printMessage("playernumber", players.size());
		return true;
	}

	public void roll(int roll) {
		printer.printMessage(players.get(currentPlayer),"currentplayer");
		printer.printMessage("rolled",roll);
		
		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				printer.printMessage(players.get(currentPlayer),"");
				preparingForAskingQuestion(roll);
			} else {
				printer.printMessage(players.get(currentPlayer),"outpenalty");
				isGettingOutOfPenaltyBox = false;
			}
			
		} else {
			preparingForAskingQuestion(roll);
		}
	}

	protected void preparingForAskingQuestion(int roll) {
		places[currentPlayer] = places[currentPlayer] + roll;
		if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
		
		printer.printMessage(players.get(currentPlayer) 
				, "playerlocation" 
				, places[currentPlayer]);
		printer.printMessage("category",currentCategory());
		askQuestion();
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			printer.printMessage(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			printer.printMessage(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			printer.printMessage(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			printer.printMessage(rockQuestions.removeFirst());		
	}

	// randomly return a category
	private String currentCategory() {
		if (places[currentPlayer] == 0) return "Pop";
		if (places[currentPlayer] == 4) return "Pop";
		if (places[currentPlayer] == 8) return "Pop";
		if (places[currentPlayer] == 1) return "Science";
		if (places[currentPlayer] == 5) return "Science";
		if (places[currentPlayer] == 9) return "Science";
		if (places[currentPlayer] == 2) return "Sports";
		if (places[currentPlayer] == 6) return "Sports";
		if (places[currentPlayer] == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				currentCoinsAfterCorrectAnswer();	
				return checkingPlayerWinner();
			} else {
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				return true;
			}
		} else {
			currentCoinsAfterCorrectAnswer();
			return checkingPlayerWinner();
		}
	}

	protected boolean checkingPlayerWinner() {
		boolean winner = didPlayerWin();
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		
		return winner;
	}

	protected void currentCoinsAfterCorrectAnswer() {
		printer.printMessage("correctanswer");
		purses[currentPlayer]++;
		printer.printMessage(players.get(currentPlayer) 
				, "now"
				, purses[currentPlayer]
				, "coins");
	}
	
	public boolean wrongAnswer(){
		printer.printMessage("incorrectanswer");
		printer.printMessage(players.get(currentPlayer), "sentbox");
		inPenaltyBox[currentPlayer] = true;
		
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}

	/**
	 * Tells if the last player won.
	 */
	private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}
}
