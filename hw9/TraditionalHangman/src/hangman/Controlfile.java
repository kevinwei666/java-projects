package hangman;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
 /**
  * the class to control file
  * @author weikevin
  *
  */
    public class Controlfile {
    /**
     * the constructor
     */
	public Controlfile() {
		
	}
	/**
	 * to test if the word if legal.
	 * @param strLine the word
	 * @return yes, return true, no return false
	 */
	public boolean IfTheWordIsLegal(String strLine) {
		if(this.IfHasUpper(strLine)==false) {
			return false;
		}
		if(this.IfHasDot(strLine)==false) {
			return false;
		}
		if(this.IfHasApostrophe(strLine)==false) {
			return false;
		}
		if(this.IfHasHyphen(strLine)==false) {
			return false;
		}
		if (this.IfCompound(strLine)==false) {
			return false;
		}
	    if (this.IfHasDigits(strLine)==true) {
	    	return false;
	    }
	    return true;
		
	}
	/**
	 * determine if the string has uppercase
	 * @param s the string
	 * @return yes, return true. no return false
	 */
	public boolean IfHasUpper(String s) {
		for (int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			if (c>=65 && c<=90){
				return false;
			}
		}
		return true;
	}
	/**
	 * determine if the string has the dot
	 * @param s the string
	 * @return yes, return true. no return false
	 */
	public boolean IfHasDot(String s) {
		for (int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			if (c==46){
				return false;
			}
		}
		return true;
	}
	/**
	 * determine if the string has apostrophe
	 * @param s the string
	 * @return yes, return true. no, return false
	 */
	public boolean IfHasApostrophe(String s) {
		for (int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			if (c==39){
				return false;
			}
		}
		return true;
	}
	/**
	 * determine if the string has the hyphen
	 * @param s the string
	 * @return yes, return true. no return false.
	 */
	public boolean IfHasHyphen(String s) {
		for (int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			if (c==45){
				return false;
			}
		}
		return true;
	}
	/**
	 * determine if the string is compound word
	 * @param s the string
	 * @return yes, return true. no return false.
	 */
	public boolean IfCompound(String s) {
		String[] arr=s.split(" ");
		if (arr.length>1) {
			return false;
		}
		return true;
	}
	/**
	 * determine if the string has the digit
	 * @param s the string
	 * @return yes, return true. no return false.
	 */
	public boolean IfHasDigits(String s) {
		 boolean containsDigit = false;

		    if (s != null && !s.isEmpty()) {
		        for (char c : s.toCharArray()) {
		            if (containsDigit = Character.isDigit(c)) {
		                break;
		            }
		        }
		    }

		    return containsDigit;
	}
	/**
	 * get the value of a line in the file randomly
	 * @param file the file
	 * @return the word
	 * @throws FileNotFoundException the file
	 */
	public String RandomLineInFile(File file) throws FileNotFoundException {
		String result = null;
		Random rand= new Random();
		int n=0;
		for (Scanner sc=new Scanner (file); sc.hasNext();) {
			++n;
			String line=sc.nextLine();
			if(rand.nextInt(n)==0) {
				result=line;
			}
		}
		return result;
	}
	/**
	 * return the word from the file
	 * @param file the file
	 * @return the word
	 * @throws FileNotFoundException the file
	 */
	public String GetLegalWord(File file) throws FileNotFoundException {
		String word;
		while(-1<0) {
			word=this.RandomLineInFile(file);
			if(this.IfTheWordIsLegal(word)==true) {
				break;
			}
		}
		return word;	
	}
    }
