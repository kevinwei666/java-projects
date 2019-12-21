package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
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
	 * the start method 
	 * @throws FileNotFoundException the file
	 */
	public void start() throws IOException {
		File file;
		file=new File("words.txt");//the file used in this program
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the hangman!!\n\n");
			this.word=control.GetLegalWord(file);
			
		int wordLength=this.word.length();
			for(int i=0;i<wordLength;++i) {
				System.out.print("\t_");
			}
			
			String[]boardArray= new String [this.word.length()];
			ArrayList<String> wordlist = new ArrayList<String>();
			for(int a=0;a<this.word.length();++a) {
			boardArray[a]="_";
			}
		//set the random
	    Random random=new Random();
	    //get the random from1 and 2
		int modeOfGame= random.nextInt(2);
		//the traditional version
		if (modeOfGame==1) {
		//set the loop
		while (this.play == true) {
			
			System.out.println("\nGuess a letter\n");
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
				System.out.println("\ncongratulation! you win!,this is traditional hangman");
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
		//the evil version
		else {
			//the arraylist of the legal word
			ArrayList<String> legalWordList = new ArrayList<String>();
			legalWordList=this.control.GetLegalWordArraylist(file);
			//set the dynamical arraylist
			ArrayList<String> dynamicList = this.initialList(wordLength, legalWordList);
			while (this.play == true) {
				
				System.out.println("\n");
				System.out.println("\nGuess a letter\n");
				String inputOfUser = scanner.nextLine();
				//update the list by the input letter and generate the new group of word
				dynamicList=this.updateList(inputOfUser, dynamicList);
				//get the first word in the list
				this.word=dynamicList.get(0);
				this.ifInString(inputOfUser, this.word);
				
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
				//deyermine if game over
				this.ifGameOver(boardArray);
				if(this.ifGameOver(boardArray)==true) {
					System.out.println("\ncongratulation! you win!,this is evil hangman");
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
		}
	/**
	 * determine if the letter in the word string
	 * @param letter input og users
	 * @param word the word
	 * @return in, return true, otherwise, return false
	 */
	public boolean ifInString( String letter, String word) {
		//determine if the letter in the word
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
	 /**
	  * return the length of a string
	  * @param word the word
	  * @return the length
	  */
	 public int lengthOfString(String word) {
		 String[] s=word.split("");
		 int length=s.length;
		 return length;
		 
	 }
	 
	 
	 /**
	  * generate the key value of the hashmap 
	  * @param input the letter
	  * @param word the word in the list
	  * @return the key value
	  */ 
	 public static String generateKeyValue(String input, String word)
		{
			String keyValue = "";
			char a;
			a=input.charAt(0);
			char tmpChar;
			
			for(int i=0; i<word.length(); ++i)
			{
				tmpChar = word.charAt(i);
				if(a==tmpChar)
					keyValue+="_";
				else
					keyValue+="/";
			}
			
			return keyValue;
		}
	 /**
	  * get the wordlist with the word length
	  * @param length word length
	  * @param legalList thelist of the legal word
	  * @return the new arraylist
	  */ 
	 public ArrayList<String> initialList(int length, ArrayList<String> legalList){
			ArrayList<String> newArray = new ArrayList<String>();
			for(String words: legalList)
			{
				if(words.length() == length)
					newArray.add(words);
			}
			
			return newArray;
		}
	 /**
	  * update the list with the input leeter
	  * @param input the letter
	  * @param oldList the list which is before update
	  * @return the new list
	  */
	 public static ArrayList<String> updateList (String input, ArrayList<String> oldList)
		{
		    //create the new hashmap variable
			HashMap<String, ArrayList<String>> newList = new HashMap<>();
			String mapKeyValue;
			int length = 0;
			ArrayList<String> nextList = new ArrayList<String>();
			
			for(String words : oldList)
			{
				mapKeyValue = generateKeyValue(input, words);
				ArrayList<String> tmpArray = new ArrayList<String>();
				
				if(newList.containsKey(mapKeyValue))
				{
					tmpArray = newList.get(mapKeyValue);
					tmpArray.add(words);
					newList.put(mapKeyValue, tmpArray);
				}
				else
				{
					tmpArray.add(words);
					newList.put(mapKeyValue, tmpArray);
				}			
			}

			for(ArrayList<String> values: newList.values())
			{
				
				if(values.size() > length)
				{
					length = values.size();
					nextList = (ArrayList<String>) values.clone();
				}
				
			}
				
			return nextList;		
		}
	 
	 /**
		 * the main function of this program
		 * @param args value
		 * @throws FileNotFoundException the file
		 */
		public static void main(String[] args) throws IOException {
			playcontroller game = new playcontroller();
			game.start();//the start game method to operate the game
		}
}
