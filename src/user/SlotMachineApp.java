package user;
import machine.*;

public class SlotMachineApp {
	
	public static void main(String[] args) {
		
		int gameCount = 1;
		Player p = new Player();

		// print out token at the beginning of the game
		System.out.println("Player has " + p.getToken() + " tokens");
		// check if game over
		while(p.getToken() > 0){
			// identify what theme to use
			int theme = gameCount-1;
			ThemedMachine machine = new ThemedMachine(theme);
			p.loseToken();
			System.out.println("Game " + gameCount + " - use 1 token, reduced token to " + p.getToken() );
			machine.play();
			machine.draw();

			// add game logic here
			gameCount++;
			switch(machine.getEvent()){
				case ThemedMachine.WINNER: {
					System.out.println("Added 2 tokens");
					p.addToken(2);
					break;
				}
				case ThemedMachine.GOOD_GAME:{
					System.out.println("Added 1 token");
					p.addToken(1);
					break;
				}
			}

			System.out.println("Tokens on hand: " + p.getToken());
			System.out.println();

		}
		// game exit
		System.out.println("Sorry, no more tokens left!");

		



//		machine.displaySlots();


//		machine.displayImageFrequency();
//		machine.displaySlots();
	}
	
}
