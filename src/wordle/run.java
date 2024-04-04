package wordle;
import java.util.Scanner;

public class run {
	public static void main(String[] args) {
		
		game thing = new game();
		
		word th = (thing.get_word());
		
		Scanner scanner = new Scanner(System.in);
		
		while(thing.guesses_count() < 6) {
	        
	        System.out.println("Please enter a 5 letter word:");


	        // Read user input
	        String userInput = scanner.nextLine().toLowerCase();
	        
	        if (userInput.length() == 5) {
	        	if (thing.valid_word(userInput)) {
	    	        boolean result = thing.user(userInput);
			        
			        if (result) {
			        	System.out.println("You Win");
						break;
			        }
	        	}
	        	else {
	        		System.out.println("Invalid word");
	        	}
	        	
	        }
	        else {
	        	System.out.println("Word must be 5 characters");
	        }
			
		}

		if (thing.guesses_count() >= 6) {
			System.out.println("You lose!");
			System.out.printf("Word was: %s \n", th.get_word());
		}
		
        scanner.close();
	}

}
