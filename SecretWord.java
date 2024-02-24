

public class SecretWord {
	
	
	private String secretWord = getRandomWord();
	private String wordWithBlanks = convertWordToBlanks();
	private String wordFillIn = wordWithBlanks;
	
	public SecretWord() {
		//this.secretWord = secretWord;
	}
	

	public String convertWordToBlanks() {
		//System.out.println(secretWord);
		String blank = "";
		for (int i = 0; i < secretWord.length(); i++) {
			blank = blank + "_";
		}
		return blank;
	}

	public int countNumberOfBlanks() {
		String update = wordWithBlanks;
		int sum = 0;
		for (int i = 0; i < update.length(); i++) {
			if (update.substring(i,i+1).equals("_")) {
				sum = sum +1;
			}
		}
		return sum;
	}
	
	
	public String replaceBlanksWithChar(char ch) {
		//System.out.println(secretWord);
		char compare  = ch; 
		String front = "";
		String back = ""; 
		String result = "";
		String update = wordWithBlanks; 
		
		for (int i = 0; i < wordWithBlanks.length(); i++) {
			if(secretWord.charAt(i) == (compare)) {
				front = update.substring(0,i);
				back = update.substring(i+1,wordWithBlanks.length());
				update = front + ch + back; 
			}
			result = update;
		}
		wordWithBlanks = result;
		return result; 
	}
		
	public boolean isInWord(char ch) {
		boolean inWord = false;
		for (int i = 0; i < secretWord.length(); i++) {
			if (secretWord.charAt(i)==(ch)) {
				inWord = true;
			}
		}
		return inWord;
	}
	
	public int timesInWord(char ch) {
		int sum = 0;
		for (int i = 0; i < secretWord.length(); i++) {
			if (secretWord.charAt(i)==(ch)) {
				sum++;
			}
		}
		return sum;
	}
	
	public String getRandomWord() {
			String[] randWord = Dictionary.readArrayFile("wordlist.10000.txt");
			int randNum = (int)(Math.random()*randWord.length);
			return randWord[randNum];
		
	}
	
	public int lenOfWord() {
		return secretWord.length();
		
	}

	public String getWordWithBlanks() {
		return wordWithBlanks;
	}
	public String getWordFillIn() {
		return wordFillIn;
	}
	public String getSecretWord() {
		return secretWord;
	}

	

}
