/**
 *
 */
import java.util.*;
import java.io.*;

/** A working hangman game using random words from a dictionary file.
 * @author Logan Murphy
 * @version 1.0
 */
public class Project_4 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scnr = new Scanner(System.in);
		boolean gameEnd = false;
		
		//while gameEnd is false the game loops
		while(!gameEnd) {
			//reads the dictionary file, chooses a random word, and creates a pound(#) for that random word
			String[] words = readFile("/Users/logan/Downloads/Project_4 packet/dictionary.txt");
			String randomWord = chooseRandomWord(words);
			String pound = createPound(randomWord);
			
			int incorrectGuesses = 0;
			//while the number of incorrect guesses is less than 7, loop the guessing prompt
			while(incorrectGuesses < 7) {
				//prompt the user to guess a letter
				System.out.println("Guess any letter in the word");
				System.out.println(pound);
				
				//take a guess from the user
				char guess = scnr.next().charAt(0);
				//if the guess is correct
				if(randomWord.indexOf(guess) != -1) {
					pound = guessWord(guess, randomWord, pound);
					//check to see if the user has won, break the loop if so
					if(pound.indexOf('#') == -1) {
						System.out.println("Correct! you have won this game. The word is: " + pound);
						break;
					//if the guess is incorrect
					} else {
						System.out.println(pound);
					}
				}
				else {
					//increment the number of incorrect guesses and generate the appropriate hangman image
					incorrectGuesses++;
					hangmanImage(incorrectGuesses, randomWord);
				}
			}
			//ask the user whether they would like to continue playing
			System.out.println("Do you still want to play?");
			String keepPlaying = scnr.next();
			//if the user answers no, gameEnd is set to true, loop ends
			if(keepPlaying.equals("no") || keepPlaying.equals("No")) {
				gameEnd = true;
			}
		}
	}

	//method to read a file and turn it into an array of strings
	//exception is thrown if given file not found
	public static String[] readFile(String fileName) throws FileNotFoundException {
		Scanner fileInput = new Scanner(new File(fileName));
			
		//find the amount of lines with data in the file
		int fileLength = 0;
		while(fileInput.hasNext()) {
			fileInput.next();
			fileLength++;
		}
		fileInput.close();
		
		//parse each line of the file and put each string into array
		String[] fileArray = new String[fileLength];
		fileInput = new Scanner(new File(fileName));
		int i = 0;
		while(fileInput.hasNext()) {
			fileArray[i] = fileInput.next();
			i++;
		}
		fileInput.close();
		
		//return array of strings
		return fileArray;

	}
	
	//method to take a word and create a string of pounds(#) for the length of said word
	public static String createPound(String word) {
		String pound = "";
		for(int i = 0; i < word.length(); i++) {
			pound += "#";
		}
		return pound;
	}
	
	//method to take a guess and a word and see if the user has guessed right, and if they have, update pound with letter in all locations in word
	public static String guessWord(char guess, String word, String pound) {
		String updatedPound = pound;
		int i = 0;
		while(word.indexOf(guess, i) != -1) {
			updatedPound = updatedPound.substring(0, word.indexOf(guess,i)) + guess + updatedPound.substring(word.indexOf(guess,i)+1, pound.length());
			i++;
		}
		return updatedPound;
	}
	
	//method to take an array of words and use Math.Random to choose a random word within the bounds of the list
	public static String chooseRandomWord(String[] words) {
		Random rnd = new Random();
		int randomInt = rnd.nextInt((words.length));
		return words[randomInt];
	}
	
	//method to generate the appropriate hangman image given a count of incorrect guesses
	public static void hangmanImage(int count, String word) {
		if (count == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (count == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (count == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (count == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("GAME OVER! The word was " + word);
		}
	}

}
