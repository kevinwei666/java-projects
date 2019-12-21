package hangman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * test the controlfile
 * @author weikevin
 *
 */
class ControlfileTest {
	/**
	 * the controlfile variable
	 */
	Controlfile a;
	/**
	 * the word to use
	 */
	String word;
	

	@BeforeEach
	/**
	 * initial the variable
	 * @throws Exception
	 */
	void setUp() throws Exception {
		//initial the instance variable
		a=new Controlfile();
	}
	/**
	 * test the ifhasupper method
	 */

	@Test
	void IfHasUppertest() {
		word="sgs";
		assertTrue(a.IfHasUpper(word));
		word="sGs";
		assertFalse(a.IfHasUpper(word));
		word="sGG";
		assertFalse(a.IfHasUpper(word));
	}
	/**
	 * test the IfHasDot method
	 */
	@Test
	void IfHasDottest() {
		word="sgs";
		assertTrue(a.IfHasDot(word));
		word="sG.s";
		assertFalse(a.IfHasUpper(word));
		word="sGG.";
		assertFalse(a.IfHasUpper(word));
	}
	/**
	 * test the IfHasApostrophe method
	 */
	@Test
	void IfHasApostrophetest() {
		word="sgs";
		assertTrue(a.IfHasApostrophe(word));
		word="sG's";
		assertFalse(a.IfHasApostrophe(word));
		word="s'GG";
		assertFalse(a.IfHasApostrophe(word));
	}
	/**
	 * test the IfHasHyphen method
	 */
	@Test
	void IfHasHyphentest() {
		word="sgs";
		assertTrue(a.IfHasHyphen(word));
		word="sG-s";
		assertFalse(a.IfHasHyphen(word));
		word="s-GG";
		assertFalse(a.IfHasHyphen(word));
	}
	/**
	 * test the IfCompound method
	 */
	@Test
	void IfCompoundtest() {
		word="sgs";
		assertTrue(a.IfCompound(word));
		word="sGy ishir";
		assertFalse(a.IfCompound(word));
		word="sGG se r";
		assertFalse(a.IfCompound(word));
	}
	/**
	 * test the IfHasDigit method
	 */
	@Test
	void IfHasDigitstest() {
		word="sgs";
		assertFalse(a.IfHasDigits(word));
		word="sGy8ishir";
		assertTrue(a.IfHasDigits(word));
		word="sGGse3 r";
		assertTrue(a.IfHasDigits(word));
	}
	/**
	 * test the IfTheWordLegal method
	 */
	@Test
	void IfTheWordIsLegaltest() {
		word="sgs";
		assertTrue(a.IfTheWordIsLegal(word));
		word="sGy8ishir";
		assertFalse(a.IfTheWordIsLegal(word));
		word="sGGse3 r";
		assertFalse(a.IfTheWordIsLegal(word));
		word="sGGse3-r";
		assertFalse(a.IfTheWordIsLegal(word));
		word="sGGse3''r";
		assertFalse(a.IfTheWordIsLegal(word));
	}
	


}
