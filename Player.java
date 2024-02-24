
public class Player {
	private String name;
	private int balance = 0;
	//private boolean solved;
	
	
	public static boolean guess(char guess) {
		if (guess == 'a' || guess == 'b'|| guess == 'c' || guess == 'd' || guess == 'e'|| guess == 'f' ||
				guess == 'g' || guess == 'h'|| guess == 'i'|| guess == 'j' || guess == 'k'|| guess == 'l'
				|| guess == 'm' || guess == 'n'|| guess == 'o' || guess == 'p' || guess == 'q'|| guess == 'r'
				|| guess == 's' || guess == 't'|| guess == 'u' || guess == 'v' || guess == 'w'|| guess == 'x' || guess == 'y' || guess == 'z') {
			return true;
		}
		else {
			return false;
		}
		// in runner make a loop that while the letter is not valid
		// guess a new letter
	}
	
	public Player(String name) {
		this.name = name;
	}

	public boolean conOrVowel(char guess) {
		if (guess == 'a' || guess == 'e'|| guess == 'i' || guess == 'o' || guess == 'u') 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		if (balance < 0) {
			balance = 0;
		}
		return balance;
	}
	public void setBalance(int change) {
		this.balance = balance + change;
	}


	//public boolean isSolved() {
	//	return solved;
	//}

	//public void setSolved(boolean solved) {
	//	this.solved = solved;
	//}
	
	
}
