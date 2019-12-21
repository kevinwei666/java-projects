package hangman;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * to test the playcontroller
 * @author weikevin
 *
 */
class playcontrollerTest {
	/**
	 * the letter used
	 */
	String letter;
	/**
	 * the word used
	 */
	String word;
	/**
	 * the playcontroller variable
	 */
	playcontroller player;
	/**
	 * the string arrays
	 */
	String []a= {"q","_"};
	String []b= {"w","u","h"};
	String []c= {"_","_"};
	ArrayList<String> wordlist = new ArrayList<String>();
	/**
	 * initialize the variable
	 * @throws Exception value
	 */
	@BeforeEach
	void setUp() throws Exception {
		player=new playcontroller();
	}

	/**
	 * to test ifinstring method
	 */
	@Test
	void ifInStringtest() {
		word="abc";
		letter="a";
		assertTrue(player.ifInString(letter, word));
		letter="s";
		assertFalse(player.ifInString(letter, word));
		letter="ab";
		assertFalse(player.ifInString(letter, word));
	}
	/**
	 * to test ifgameover method
	 */
	@Test
	void ifGameOvertest() {
		
		assertTrue(player.ifGameOver(b));
		
		assertFalse(player.ifGameOver(a));
		
		assertFalse(player.ifGameOver(c));	
	}
	/**
	 * test the ifinarray method
	 */
	@Test
	void ifInArraytest() {
		letter="w";
		assertTrue(player.ifInArray(b ,letter));
		letter="s";
		assertFalse(player.ifInArray(b ,letter));
		letter="ab";
		assertFalse(player.ifInArray(b ,letter));
			
	}
	/**
	 * test the ifinarraylist method
	 */
	
	@Test
	void ifInArrayListtest() {
		this.wordlist.add("w");
		letter="w";
		assertTrue(player.ifInArrayList(wordlist ,letter));
		letter="s";
		assertFalse(player.ifInArrayList(wordlist ,letter));
		letter="ab";
		assertFalse(player.ifInArrayList(wordlist ,letter));
			
	}
}
