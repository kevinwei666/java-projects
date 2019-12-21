package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * the class of the playcontroller
 * @author weikevin
 *
 */
public class playcontroller {
	/**
	 * the variable contol to control to file
	 */
	private Controlfile control;
	/**
	 * the boolean value to determine if to play
	 */
	private boolean play;
	/**
	 * the word that used in this program
	 */
	private String word;
    /**
     * the constructor of the class
     */
	public playcontroller() {
		//initialize the variables 
		this.control=new Controlfile();
		this.play = true;
	}
	/**
	 * the main function of this program
	 * @param args value
	 * @throws FileNotFoundException the file
	 */
	public static void main(String[] args) throws FileNotFoundException {
		playcontroller game = new playcontroller();
		game.start();//the start game method to operate the game
	}
	/**
	 * the start method 
	 * @throws FileNotFoundException the file
	 */
	public void start() throws FileNotFoundException {
		File file;
		file=new File("words.txt");//the file used in this program
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the hangman!!\n\n");
			this.word=control.GetLegalWord(file);
			System.out.println(this.word);
		int wordLength=this.word.length();
			for(int i=0;i<wordLength;++i) {
				System.out.print("\t_");
			}
			
			String[]boardArray= new String [this.word.length()];
			ArrayList<String> wordlist = new ArrayList<String>();
			for(int a=0;a<this.word.length();++a) {
			boardArray[a]="_";
			}
		//set the loop
		while (this.play == true) {
			
			System.out.println("\nGuess a letter,(input ! to quit)\n");
			String inputOfUser = scanner.nextLine();
			
			//if the input letter is in the string
			if (this.ifInString(inputOfUser,this.word)==true) {
				    String[] s=word.split("");
				    if(this.ifInArray(boardArray, inputOfUser)==true) {
				    	System.out.print("you have guessed this letter before and it is shown\n");
				    	
				    }
				
					for (int i=0;i<s.length;++i) {
						if(s[i].equals(inputOfUser)) {
							boardArray[i]=inputOfUser;
						}
						
					}
					for(int a=0;a<this.word.length();++a) {
						System.out.print("\t");
						System.out.print(boardArray[a]);
					}
				
			}
			else {
				System.out.print("\nwrong guessing");
				System.out.print("\t");
				System.out.print(inputOfUser);
				System.out.print("\n");
			    //if the users input the wrong word twice.
				if(this.ifInArrayList(wordlist, inputOfUser)==true) {
					System.out.println("you have guessed this letter before and it is wrong");
					
				}
				//add the wrong input in the arraylist
				if(this.ifInArrayList(wordlist, inputOfUser)==false) {
					wordlist.add(inputOfUser);
					
				}
				
			}
			//deterimine if gameover
			this.ifGameOver(boardArray);
			if(this.ifGameOver(boardArray)==true) {
				System.out.println("\ncongratulation! you win!");
				System.out.println("do u want to play again,y/n");
				String inputUser = scanner.nextLine();
				//let the users to play again or not
				if(inputUser.equals("y"))
				{
					this.play=true;
					System.out.println("Welcome to the hangman!!\n\n");
					this.word=control.GetLegalWord(file);
					System.out.println(this.word);
				    wordLength=this.word.length();
					for(int i=0;i<wordLength;++i) {
						System.out.print("\t_");
					}
					
					
					for(int a=0;a<this.word.length();++a) {
					boardArray[a]="_";
					}
				}
				else {
					System.out.println("bye-bye");
					this.play=false;
				}
				
				
			}
			}
		}
	/**
	 * determine if the letter in the word string
	 * @param letter input og users
	 * @param word the word
	 * @return in, return true, otherwise, return false
	 */
	public boolean ifInString( String letter, String word) {
		String[] s=word.split("");
		for (int i=0; i<s.length;++i) {
			if(letter.equals(s[i])) {
				return true;
			}
		}
		return false;
	}
	/**
	 * determine if the game over
	 * @param boardArray the array
	 * @return yes, return true. no, return false
	 */
	public boolean ifGameOver(String [] boardArray) {
		int a=0;
		a=boardArray.length;
		String obj = "_";
		for(int i=0;i<a;++i) {
			
			if(boardArray[i].equals(obj)) {
			return false;}
		}
		return true;
	}
	/**
	 * determine if the word in a string array
	 * @param boardArray the array
	 * @param letter the letter
	 * @return yes, return true. no return false
	 */
	public boolean ifInArray (String [] boardArray, String letter) {
		int a=0;
		a=boardArray.length;
		for(int i=0;i<a;++i) {
			if(boardArray[i].equals(letter)) {
				return true;
			}
			}
		return false;
	    }
	/**
	 * determine if the letter in the arraylist
	 * @param wordlist the arraylist
	 * @param letter the letter
	 * @return yes,return true. no, return false
	 */
	 public boolean ifInArrayList(ArrayList<String> wordlist,String letter ) {
		if(wordlist.contains(letter)) {
			return true;
		}
		return false;
	}	

}
