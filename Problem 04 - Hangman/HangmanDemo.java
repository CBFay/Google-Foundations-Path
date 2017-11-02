/**
 * from https://techdevguide.withgoogle.com/paths/foundational/
 * created 10.17.2017 by CB Fay
 */

import java.io.*; // contains BufferedReader, FileReader, FileNotFoundException
import java.util.*; // contains ArrayList, Scanner, Random

class Hangman {

	// instance variables
	private String answer;
	private int size;
	private int guessRemain;
	private int unknownRemain;
	private char[] blanks;
	private boolean gameOver = false;

	private Scanner input = new Scanner(System.in);
	private Random rng = new Random();

	// Construct a new hangman given a string
	Hangman(String answer) {

		this.answer = answer.toUpperCase();

		size = answer.length();
		unknownRemain = size;
		blanks = new char[size];

		guessRemain = 8; // number of guesses allowed

		// fill blanks with dashes
		for(int i = 0; i < size; i++) {
			blanks[i] = '-';
		}
	}

	// Construct a new hangman given no parameters
	Hangman() {

		// pick a random String from a HangmanLexicon object
		HangmanLexicon lex = new HangmanLexicon();
		answer = lex.getWord(rng.nextInt(lex.getWordCount())).toUpperCase();

		size = this.answer.length();
		blanks = new char[size];
		unknownRemain = size;

		guessRemain = 8; // number of guesses allowed

		// fill blanks with dashes
		for(int i = 0; i < size; i++) {
			blanks[i] = '-';
		}
	}

	// print out the letters that the user has guessed
	private String getBlanks() {
		String b = new String(blanks);
		return b;
	}

	// print out the amount of guesses remaining
	private int getGuessRemain() {
		return guessRemain;
	}

	private boolean ask() {
		char guess;
		String userIn;
		boolean correct = false;

		System.out.print("Your guess: ");

		// get user input with the Scanner and make it uppercase
		userIn = (input.nextLine()).toUpperCase();

		 if (validInput(userIn))
			 guess = userIn.charAt(0);

		else {
			System.out.println("That guess is invalid.");
			return false;
		}

		System.out.println();

		// see if the guess was correct
		for(int i=0; i < size; i++) {
			if (blanks[i] == guess) {
				System.out.println("You've already tried that letter...");
				return false;
			}
			if (answer.charAt(i) == guess) {
				unknownRemain--;
				blanks[i] = answer.charAt(i);
				correct = true;
			}
		}

		if(correct == true) {
			System.out.println("That guess is correct!");
		}

		else {
			System.out.println("There are no " + guess + "\'s in the word.");
			guessRemain--;
		}

		return correct;
	}

	private boolean validInput(String userIn) {

		// reject input that isn't one character long
		if (userIn.length()>1 | userIn.length()==0) {
			return false;
		}

		// reject input that isn't alphabetical
		else if (userIn.charAt(0) < 'A' | userIn.charAt(0) > 'Z') {
			return false;
		}

		else
			return true;

	}

	private void gameContinue()	{

		// if the user ran out of guesses...
		if(guessRemain == 0) {
			gameOver = true;
			System.out.println("You lose!");
			System.out.println("The word was " + answer);
		}

		// if the user found every letter...
		if(unknownRemain == 0) {
			gameOver = true;
			System.out.println("The word now looks like this: " + getBlanks());
			System.out.println("\nYou win!");
		}
	}

	void play() {
		System.out.println("Welcome to Hangman!");

		while( gameOver == false) {
			System.out.println("The word now looks like this: " + getBlanks());
			System.out.println("Remaining guesses: " + getGuessRemain());

			ask();
			gameContinue();

			System.out.println();
		}
	}

}

class HangmanLexicon {

	ArrayList<String> wordList = new ArrayList<String>();

	HangmanLexicon() {

		String lexFile = ".\\HangmanLexicon.txt";
		String line = "";
		String cvsSplitBy = ",";
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(lexFile));
		}
		catch (FileNotFoundException exc) {
			System.out.println(lexFile + " was not found.");
			System.exit(0);
		}

		try {
			while ((line = reader.readLine()) != null) {
				wordList.add(new String(line));
			}
		}
		catch (IOException exc) {
			exc.printStackTrace();
		}


	}

	int getWordCount() {
		return wordList.size();
	}

	String getWord(int i) {
		return wordList.get(i);
	}
}

class HangmanDemo {

	public static void main(String[] args) {

		Hangman game = new Hangman();
			game.play();

	}
}
