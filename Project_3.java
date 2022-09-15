/**This program creates a basic tic-tac-toe game using multi-dimensional arrays, loops, and if-else statements. 
 * @author Logan
 * @version 1.0
 */

//imports
import java.util.Scanner;

public class Project_3 {
	
	//method to print the current state of the Tic Tac Toe board
	public static void printBoard(char[][] ticTacArray) {
		System.out.println("--------------------------------");
		System.out.println("/-----|-----|-----\\");
		System.out.println("|  " + ticTacArray[0][0] + "  |  " + ticTacArray[0][1] +
				"  |  " + ticTacArray[0][2] + "  |");
		System.out.println("|-----------------|");
		System.out.println("|  " + ticTacArray[1][0] + "  |  " + ticTacArray[1][1] +
				"  |  " + ticTacArray[1][2] + "  |");
		System.out.println("|-----------------|");
		System.out.println("|  " + ticTacArray[2][0] + "  |  " + ticTacArray[2][1] +
				"  |  " + ticTacArray[2][2] + "  |");
		System.out.println("/-----|-----|-----\\");
	}
	
	//method to check the current row for a horizantal win
	public static boolean checkRow(char[][] ticTacArray, char currentLetter, int currentX) {
		int count = 0;
		for(int i = 0; i < 3; i++) {
			if(ticTacArray[currentX][i] == currentLetter) {
				count++;
			}
		}
		return (count == 3);
	}
	
	//method to check the current column for a vertical win
	public static boolean checkColumn(char[][] ticTacArray, char currentLetter, int currentY) {
		int count = 0;
		for(int i = 0; i < 3; i++) {
			if(ticTacArray[i][currentY] == currentLetter) {
				count++;
			}
		}
		return (count == 3);
	}
	
	//method to check for a diagonal win
	public static boolean checkDiagonal(char[][] ticTacArray, char currentLetter) {
		if(ticTacArray[1][1] == currentLetter) {
			if(ticTacArray[0][0] == currentLetter && ticTacArray[2][2] == currentLetter) {
				return true;
			}
			else if(ticTacArray[0][2] == currentLetter && ticTacArray[2][0] == currentLetter) {
				return true;
			}
			else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	//method to check for a win of any type by calling the three check methods
	public static boolean checkForWin(char[][] ticTacArray, char currentLetter, int currentX, int currentY) {
		if(checkRow(ticTacArray, currentLetter, currentX)) {
			return true;
		}
		else if(checkColumn(ticTacArray, currentLetter, currentY)) {
			return true;
		}
		else if(checkDiagonal(ticTacArray, currentLetter)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//main method
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		char[][] ticTac = new char[3][3];
		
		//game start
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ticTac[i][j] = 'E';
			}
		}
		System.out.println("Welcome to 2 Player Tic Tac Toe.");
		printBoard(ticTac);
		
		//initializing game
		int turnNumber = 1;
		boolean playerOneWin = false;
		boolean playerTwoWin = false;
		boolean playerOneTurn = true;
		boolean playerTwoTurn = false;
		System.out.println("X's will play first. Enter the slot coordinates to place X in: ");
		
		//game loop that iterates until one of the players win or all 9 turns are over
		while (!(playerOneWin || playerTwoWin)) {
			//sentinel - if all turns played, break loop
			if (turnNumber > 9) {
				break;
			}
			
			//player one's turn
			if (playerOneTurn) {
				System.out.println("Player 1's turn");
				int x = scnr.nextInt();
				int y = scnr.nextInt();
				//condition to check that position is on board
				if ((x < 0 || x > 2) || (y < 0 || y > 2)) {
					System.out.println("Please enter the correct slot coordinates");
					continue;
				}
				//condition to check if slot is already taken
				else if (ticTac[x][y] != 'E') {
					System.out.println("The slot is already taken: re-enter slot number:");
					continue;
				}
				//turn
				else {
					//set input position to X on board
					ticTac[x][y] = 'X';
					//coondition to see if player one wins
					if(checkForWin(ticTac, 'X', x, y)) {
						playerOneWin = true;
					}
					else {
						//switch turn to player two
						playerOneTurn = false;
						playerTwoTurn = true;
					}
				}
			} 
			//player two's turn
			else {
				System.out.println("Player 2's turn");
				int x = scnr.nextInt();
				int y = scnr.nextInt();
				//condition to check that position is on board
				if ((x < 0 || x > 2) || (y < 0 || y > 2)) {
					System.out.println("Please enter the correct slot coordinates");
					continue;
				}
				//condition to check if slot is already taken
				else if (ticTac[x][y] != 'E') {
					System.out.println("The slot is already taken: re-enter slot number:");
					continue;
				}
				//turn
				else {
					//set input position to O on board
					ticTac[x][y] = 'O';
					//condition to see if player two wins
					if(checkForWin(ticTac, 'O', x, y)) {
						playerTwoWin = true;
					}
					else {
						//switch turn to player one
						playerTwoTurn = false;
						playerOneTurn = true;
					}
				}
			}
			//increase turn number
			turnNumber++;
		}
		
		//game end
		if(playerOneWin) {
			System.out.println("Congratulations! X's have won! Thanks for playing.");
		}
		else if(playerTwoWin) {
			System.out.println("Congratulations! O's have won! Thanks for playing.");
		}
		else {
			System.out.println("It's a draw! Thanks for playing");
		}
		System.out.println("The final result of Tic Tac Toe game is.");
		printBoard(ticTac);

	}

}
