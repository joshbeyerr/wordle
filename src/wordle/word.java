package wordle;

import java.util.ArrayList;

public class word {
	
	private String wor;
	private ArrayList<letter> characters;
	
	private char[] pureChars;
	
	private int correctLetters = 0;
	
	word(String wordd){
		wor = wordd;
		this.scrape();
	}
	
	void scrape() {
		characters = new ArrayList<>(wor.length());
		
		pureChars = new char[wor.length()];
		
		for (int i=0; i<wor.length(); i++) {
			char ch = wor.charAt(i);
			letter let = new letter(ch, i);
			characters.add(let);
			
			pureChars[i] = ch;

		}
	}
	
	ArrayList<letter> get_characters() {
		return characters;
	}
	
	String get_word() {
		return wor;
	}
	
	boolean compare(word wordToGuess) {
		
		for (int i=0; i<characters.size(); i++) {
			
			if (characters.get(i).get_char() == wordToGuess.get_characters().get(i).get_char()) {
				characters.get(i).set_correct(1);
				
				wordToGuess.get_characters().get(i).set_compare(1);
				this.correctLetters += 1;
				
			}}
		if (this.correctLetters == wordToGuess.get_word().length()) {
			return true;
		}
		else {
			for (int i=0; i<characters.size(); i++) {
				
				for (int j=0; j<wordToGuess.pureChars.length; j++) {
//					System.out.printf("%c to %c \n", characters.get(i).get_char(), wordToGuess.pureChars[j]);
					if (characters.get(i).get_char() == wordToGuess.pureChars[j]) {
						
						// if character hasnt already been marked
						if (wordToGuess.get_characters().get(j).get_compare() == 0) {
							characters.get(i).set_correct(2);
							
							wordToGuess.get_characters().get(j).set_compare(1);
							break;
						}
					}
				}
				}
		}
		this.reset_compare(wordToGuess);
		return false;
	}
	
	void reset_compare(word wordToGuess) {
		for (int i=0; i<wordToGuess.characters.size(); i++) {
			wordToGuess.characters.get(i).set_compare(0);
		}}
	
	void print_score() {
		
		for (int i=0; i<characters.size(); i++) {
			System.out.printf("Letter: %c, Score: %d \n", characters.get(i).get_char(), characters.get(i).get_correct());
		}
		
	}
	
	void print_score2() {
		for (int i=0; i<characters.size(); i++) {
			System.out.printf("%c ", characters.get(i).get_char());
		}
		System.out.print("\n");
		
		for (int i=0; i<characters.size(); i++) {

			if (characters.get(i).get_correct() == 1) {
				System.out.print("✓ ");
			}
			else if (characters.get(i).get_correct() == 2) {
				System.out.print("| ");
			}
			else {
				System.out.print("  ");
			}
		}
		System.out.print("\n");
		
	}
	
	
	
	

}
