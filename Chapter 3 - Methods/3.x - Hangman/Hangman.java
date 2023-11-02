import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hangman {
	private static String[] words = new String[370106];
	private static String word;
	private static String hiddenLetters;
	private static int incorrectCount = 0;
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("words_alpha.txt");
		Scanner fileScan = new Scanner(file);
		int i = 1;
        while(fileScan.hasNextLine()){
            String line = fileScan.nextLine();
			words[i] = line;
			i++;
        }  
		fileScan.close();
		getWord();
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
		getGuesses();
		Board board = new Board();
	}

	public static void getGuesses() {
		while (incorrectCount < 7 && hiddenLetters.contains("*")) {
			System.out.println("Guess a letter in the word:");
			System.out.println(hiddenLetters);
			String guess = scan.next();
			
    		while (guess.matches(".*[^a-z].*")) {
        		System.out.println("Please enter letters only, try again");
        		guess = scan.next();
    		}
			while (guess.length() > 1) {
        		System.out.println("Please enter a single letter only, try again");
        		guess = scan.next();
    		}
			hang(guess);
		}
	}

	public static void hang(String guess) {
		String updatedLetters = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				updatedLetters += guess.charAt(0);
			} else if (hiddenLetters.charAt(i) != '*') {
				updatedLetters += word.charAt(i);
			} else {
				updatedLetters += "*";
			}
		}

		if (hiddenLetters.equals(updatedLetters)) {
			incorrectCount++;
			printHangman();
		} else {
			hiddenLetters = updatedLetters;
		}
		if (hiddenLetters.equals(word)) {
			System.out.println("Correct! The word was " + word);
			//System.out.println("You have " + (7-incorrectCount) + " shots in battleship");
		}
	}

	// Part 1
	// Prints out the game image to the terminal based on how many incorrect guesses have been made.
	// This game has 7 guesses. Be creative!
	public static void printHangman() {
		if (incorrectCount >= 1) {
			/**
			 * print format:
			 * Wrong guess, try again
			 * XXXX--- //depends on shots left
			 */

			System.out.println("Wrong guess, try again");
			for (int i = 0; i < 7-incorrectCount; i++) {
				System.out.print("X");
			}
			for (int i = 0; i < incorrectCount; i++) {
				System.out.print("-");
			}
			System.out.println();
			if (incorrectCount == 7) {
				System.out.println("The word was: " + word);
			}
		}
	}

	// Part 2: 
	// Modify this function to get the word to guess from user input in the terminal
	public static void getWord(){
		System.out.println("Would you like to choose a word or have a random one chosen? (y = choose, n = random)");
		String choice = scan.next();
		while (!choice.matches("y") && !choice.matches("n")) {
			System.out.println("You didn't enter y or n, try again");
			System.out.println("Would you like to choose a word or have a random one chosen? (y = choose, n = random)");
			choice = scan.next();
		}
		if (choice.matches("y")) {
			System.out.println("Choose a word:");
			word = scan.next();
			hiddenLetters = new String(new char[word.length()]).replace("\0", "*");
		}
		else if (choice.matches("n")){
			word = words[(int) (Math.random() * words.length)];
			hiddenLetters = new String(new char[word.length()]).replace("\0", "*");
		}
	}
}