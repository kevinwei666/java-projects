package battleship;
import java.util.Scanner;
/**
 * the main program of the game
 * @author weikevin
 *
 */
public class BattleshipGame {
    //instance variable
	/**
	 * the ocean variable
	 */
	private Ocean ocean;
	/**
	 * the play variable
	 */
	private boolean play;
	/**
	 * game over value
	 */
	private boolean gameOver;
	
	/**
	 * the constructor of the class
	 */
	public BattleshipGame() {
		// create an ocean object
		this.ocean = new Ocean();
		// place the ships randomly
		this.ocean.placeAllShipsRandomly();

		this.play = true;
		this.gameOver = false;
	}


	/**
	 * to start the game
	 */
	public void start() {
		
		while (this.play == true) {
			System.out.println("Welcome to the Battleship Game!\n\n");
		
			Scanner scanner = new Scanner(System.in); 
				
			
			// print the ocean
			this.ocean.print();

			while (this.gameOver == false) { 	
				// ask for input
				System.out.println("Please enter the location of shooting(row,column), or enter the q to quit the game:");
				String inputOfUser = scanner.nextLine();
				
                //to quit game
				if (inputOfUser.toLowerCase().equals("q")) {
					
					this.gameOver = true;
					// quit game
					this.quit();
				}

				else {
					// process input from string to integer
					int[] position = stringToInt(inputOfUser);

					if (position[0] == 100) {
						System.out.println("wrong input! please enter again\n");
					}

					else {
						//  shoot on the ocean 
						ocean.shootAt(position[0],  position[1]);

						// display the ocean; 
						ocean.print();
						
						// check if the game is over
						this.gameOver = ocean.isGameOver();

						if (this.gameOver == true) {
							// calculate hit rate
							

							// print final scores; 
							System.out.println("You win!! You've sunk all the ships!\n"
									+ "The total shots you've fired are " + ocean.getShotsFired() + ".\n"
									);

							// and ask the users if they wants to play again. 
							System.out.println("Do you want to play again? (enter y for yes)");
							String input = scanner.nextLine();
							if (input.equals("y")) {
								// reset the variables
								this.gameOver = false;

								// restarts
								System.out.println("new game is coming \n welcome the battleship game");

								// recreate an ocean object
								this.ocean = new Ocean();

								// place the ships randomly
								this.ocean.placeAllShipsRandomly();

								// print the ocean
								this.ocean.print();			
							}
							else {
								// quit the game
								this.quit();
							}

						}
						else {	
							// if game is not over yet, display number of ships sunk
							 ocean.returnTheType(position[0],  position[1]);
							System.out.println("number of ships sunk: " + ocean.getShipsSunk());
						}
					}
				}
			} 
		}
	}


	/**
	 * convert the string into integer array
	 * @param inputString value
	 * @return the integer value
	 */
	public int[] stringToInt(String inputString) {
		int[] numArray =  new int[2]; 
		String[] string = {};
		if (inputString.length() == 3 ) {				
			for (int i = 0; i < 2; i++) {
				try {
					// process input
					string = inputString.split(",");
					int num = Integer.parseInt(string[i]);
					numArray[i] = num;	
				}
				catch (NumberFormatException e) {
					// handle non number input
					numArray[0] =100; // tag
				}
				catch (ArrayIndexOutOfBoundsException e) {
					// prevent break down if input contains more than one ","
					numArray[0] =100; // tag
				}
			}
		}
		else {
			// if input length !=3, then it must be an invalid input
			numArray[0] =100; // tag
		}
		return numArray;
	}

	/**
	 * quit game.
	 */
	public void quit() {
		System.out.println("See you next time!");
		this.play = false;

	}
	/**
	 * the main function of the program
	 * @param args value
	 */
	public static void main(String[] args) {
		BattleshipGame game = new BattleshipGame();
		game.start();
	}

}
