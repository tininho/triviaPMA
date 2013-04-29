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
    		printer.printMessage("Please, introduce 2, 4, or a 6 players game configuration.");
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
	    
	    printer.printMessage(playerName," was added");
	    printer.printMessage("They are player number ", players.size());
		return true;
	}

	public void roll(int roll) {
		printer.printMessage(players.get(currentPlayer)," is the current player");
		printer.printMessage("They have rolled a ",roll);
		
		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				printer.printMessage(players.get(currentPlayer)," is getting out of the penalty box");
				places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
				
				printer.printMessage(players.get(currentPlayer) 
						, "'s new location is " 
						, places[currentPlayer]);
				printer.printMessage("The category is ",currentCategory());
				askQuestion();
			} else {
				printer.printMessage(players.get(currentPlayer)," is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
		
			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
			
			printer.printMessage(players.get(currentPlayer) 
					, "'s new location is " 
					, places[currentPlayer]);
			printer.printMessage("The category is ",currentCategory());
			askQuestion();
		}
		
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
				printer.printMessage("Answer was correct!!!!");
				purses[currentPlayer]++;
				printer.printMessage(players.get(currentPlayer) 
						, " now has "
						, purses[currentPlayer]
						, " Gold Coins.");
				
				boolean winner = didPlayerWin();
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				
				return winner;
			} else {
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				return true;
			}
			
			
			
		} else {
		
			printer.printMessage("Answer was corrent!!!!");
			purses[currentPlayer]++;
			printer.printMessage(players.get(currentPlayer) 
					, " now has "
					, purses[currentPlayer]
					, " Gold Coins.");
			
			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == players.size()) currentPlayer = 0;
			
			return winner;
		}
	}
	
	public boolean wrongAnswer(){
		printer.printMessage("Question was incorrectly answered");
		printer.printMessage(players.get(currentPlayer), " was sent to the penalty box");
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
