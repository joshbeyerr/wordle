package wordle;
import java.util.Random;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class game {
	
	private word wor;
	
	private int user_guesses = 0;
	
	game(){
		word thang = new word(this.RandomWordGenerator());
		
		wor = thang;
				
	}
	
	word get_word() {
		return wor;
	}
	
	int guesses_count() {
		return this.user_guesses;
	}
	
	boolean user(String guess) {
		word userWord = new word(guess);
		
		boolean result = userWord.compare(wor);
		
		userWord.print_score2();
		
		user_guesses += 1;
		
		return result;
	}
	
	String RandomWordGenerator() {
		
		try {
			  
			BufferedReader reader = new BufferedReader(new FileReader("words.txt"));

            String currentLine;
            
            ArrayList<String> wordArray = new ArrayList<>(6000);

            while ((currentLine = reader.readLine()) != null) {
            	wordArray.add(currentLine);
            }
            
            reader.close();

	        // Creating an instance of Random
	        Random random = new Random();
	        
	        String selectedWord = wordArray.get(random.nextInt(wordArray.size()));
	        
	        return selectedWord;
		}
		catch (IOException e){
			System.out.println("Cannot Read File");
			return null;
		}

	}

}
