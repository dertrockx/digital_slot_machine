package main;

public interface DigitalSlotMachine {

	String WINNER = "Winner";
	String GOOD_GAME = "Good game";
	String LOSER = "Loser";
	
	double GOOD_GAME_PERCENTAGE = 0.66d;

	void play(); // where shuffling happens
	String draw(); //return event
	String getImageStr(int i);
}
