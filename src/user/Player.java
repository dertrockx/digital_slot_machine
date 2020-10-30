package user;

public class Player {

	private int tokenOnHand;

	Player(){
		this.tokenOnHand = 4;
	}

	void viewState(){
		System.out.println("Player has " + this.tokenOnHand + " tokens .");
	}

	void loseToken(){
		this.tokenOnHand--;
	}

	void gainToken(int token){
		this.tokenOnHand += token;
	}

	int getToken(){
		return this.tokenOnHand;
	}

	// implement methods to control tokens by player
}
