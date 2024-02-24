import java.util.ArrayList;

public class Board {
	//public static void main(String[] args) {
	SecretWord word = new SecretWord();
	ArrayList<Character> lettersGuessed = new ArrayList<Character>();

//}

	public void addToList(Character letter) {
		lettersGuessed.add(letter);
	}
	
	public String parseArray() {
		String toString = "";
		for(int i = 0; i < lettersGuessed.size(); i ++) {
			toString = toString + " "+ lettersGuessed.get(i);
		}
		return toString;
	}

	public ArrayList<Character> getLettersGuessed() {
		return lettersGuessed;
	}
	public String getWordFillIn(char c) {		
		return word.replaceBlanksWithChar(c);
	}
	
	public String getWordWithBlanks() {
		return word.convertWordToBlanks();		
	}
	public int getlenOfWord() {
		return word.lenOfWord();
		
	}
	public int getCountNumberOfBlanks() {
		return word.countNumberOfBlanks();
		
	}
	public boolean getIsInWord(char c) {
		return word.isInWord(c);
		
	}
	
	public int getTimesInWord(char c) {
		return word.timesInWord(c);
	}
	public int countNumberOfBlanks() {
		return word.countNumberOfBlanks();
	}

	public String getSecretWord() {
		return word.getSecretWord();
	}
	
	
	
	


}
