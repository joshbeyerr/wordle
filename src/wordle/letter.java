package wordle;

public class letter {
	
	// 0 if not in word, 1 if correct, 2 if in word but incorrect placement
	private int correct;

	private char le;
	
	private int index;
	
	private int compare = 0;
	
	letter(char lett, int ind) {
		le = lett;
		index = ind;
	}
	
	void set_correct(int set) {
		if (set < 0 || set > 2)System.out.println("Invalid correct input");
		else {
			correct = set;
		}
	}
	
	int get_correct() {
		return correct;
	}
	
	char get_char() {
		return le;
	}
	
	int get_index() {
		return index;
	}
	
	void set_compare(int comp) {
		compare = comp;
	}
	
	int get_compare() {
		return compare;
	}

}
