
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class Game {
	String choice = "";
	boolean wait = true;
	boolean notStart = true;
	private String name;
	private int players;
	private boolean getNames = false;
	private boolean finished = false;
	private boolean wheelSpin = false;
	private Player player = new Player(name);
	private boolean winner = false;
	private char letter;
	private Board board = new Board();
	private boolean noChosenLetter = false;
	private boolean noChosenWord = false;
	private String solved;
	private String wheelBalance;
	
	public void setUp() {
		while(notStart == true) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		player = new Player(name);
		getNames = true;
	}

			public void Dogame() {		
			finished = true;
			
			Wheel wheel = new Wheel();

					while (board.getCountNumberOfBlanks() != 0) {
						while(wait == true) {
							try {
								TimeUnit.SECONDS.sleep(1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						wait = true;
							if (choice.equals("Guess")) {
								while(noChosenLetter == false) {
									try {
										TimeUnit.SECONDS.sleep(1);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								noChosenLetter = false;
								board.addToList(letter);
								if (board.getIsInWord(letter)) {
									if (player.conOrVowel(letter)) {
										wheelSpin = true;
										player.setBalance(-250); 
										wheelBalance = "-250";
										wheelSpin = false;
									}
									else {
									wheelSpin = true;
									int additionToBalance = wheel.consonantAward(board.getTimesInWord(letter));
									wheelBalance = ""+ additionToBalance;
									player.setBalance(additionToBalance);
									wheelSpin = false;
									}
								}
								else 
								{
																			
									
								}
							}
							else if(choice.equals("Solve")) 
							{
								while(noChosenWord == false) {
									try {
										TimeUnit.SECONDS.sleep(1);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								noChosenWord = false;	
								if (solved.equals(board.getSecretWord())) {
									wheelSpin = true;
									player.setBalance(500);
									wheelBalance = "500";
									wheelSpin = false;
									break;
								}
								else 
								{
									wheelSpin = true;
									player.setBalance(-500);
									wheelBalance = "-500";
									wheelSpin = false;
									
									
								}
							}
						
					}
					winner = true;
										
				}
	public String parseArray() {
		return board.parseArray();
		
	}
	public String getFullWord() {
		return board.getSecretWord();
	}
	public int getLengthOfWord() {
		return board.getSecretWord().length();
	}
								
	public String getWord() {
		return board.getWordWithBlanks();
	}
	public void setChoice(String str) {
		choice = str;
	}
	public void setWait(boolean b) {
		wait = b;
	}
	public void setNotStart(boolean b) {
		notStart = b;
	}
	public void setPlayers(int player) {
		players = player;
	}
	public int getPlayers() {
		return players;
	}
	public void setName(String n) {
		name = n;
		
	}
	public boolean getStartNames() {
		return getNames;
	}
	
	public void setLetter(char C) {
		letter = C;		
	}
	public void letterChosen(Boolean b) {
		noChosenLetter = b;
	}
	public void ChosenWord(Boolean b) {
		noChosenWord = b;
	}
	public String getWordFilledIn() {
		return board.getWordFillIn(letter);
	}
	public int getBalance() {
		return player.getBalance();
	}
	public boolean getWheelSpin() {
		return wheelSpin;
	}
	public void setMessage(String s) {
		solved = s;
	}
	public boolean getWinner() {
		return winner;
	}
	public void setWinner(boolean B) {
		winner = B;
	}
	public String getWheelBalanceUpdate() {
		return wheelBalance;
	}

//	public void updateArray(String name) {
//		player.add(new Player(name));
//	}
}
