package wordle;
import java.util.Random;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class game {
	
	private word wor;
	
	private int user_guesses = 0;
	private ArrayList<String> wordArray;
	
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
	
	boolean valid_word(String gues) {
		int low = 0;
		int high = wordArray.size() - 1;
		int mid;
		
		while (low <= high) {
			mid = (low+high)/2;
			
			int comp = gues.compareTo(wordArray.get(mid));
			
			if (comp == 0) {
				return true;
			}
			// positive if wordArray is bigger
			else if (comp > 0) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		return false;	
	}

	
	String RandomWordGenerator() {
		
		try {
			  
			BufferedReader reader = new BufferedReader(new FileReader("words.txt"));

            String currentLine;
      
            wordArray = new ArrayList<>(5757);

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
