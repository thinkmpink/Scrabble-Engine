/**
 * @author MichaelPinkham, NickAckerman
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Dictionary {
	
	private Scanner inText;
	private File inFile;
	private ArrayList<String> dictionary;
	
	public Dictionary(String[] args) throws FileNotFoundException {
		inFile = new File(args[0]);
		inText = new Scanner(inFile);
		dictionary = new ArrayList<String>(130000);
	}
	
	/**
	 * Fills the AL with the relevant dictionary
	 */
	public void fillDict() {
		while (inText.hasNextLine()) {
			String w = inText.nextLine();
			if (w.length()<=15) { // words >15 letters
				dictionary.add(w);	  // don't fit in Scrabble
			}
		}
	}
	
	/**
	 * @return the dictionary
	 */
	public ArrayList<String> returnDictionary() {
		return dictionary;
	}
	
	/**
	 * @return the dictionary word at index i
	 */
	public String getDictVal(int i) {
		return dictionary.get(i);
	}
	
	/**
	 * @return "true" if the word passed to it is in the dictionary
	 */
	public boolean wordInDict(String word) {
		return dictionary.contains(word);
	}
}
