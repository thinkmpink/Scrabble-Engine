/**
 * @author MichaelPinkham, NickAckerman
 */

import java.util.ArrayList;

public class Player {

	private ArrayList<String> hand;
	private int currentScore;
	private final int handLen;
	private String name;

	public Player() {
		hand = new ArrayList<String>();
		currentScore = 0;
		handLen = 7;
		name = "";
	}

	
	/**
	 * Fills the Player's hand with 7 letters if possible, else
	 * fills it with what's left in the Bag
	 */
	public void fillHand(Board b) {
		ArrayList<String> bag = b.getBag();
		final int numLettersNeeded = handLen-hand.size();
		for (int i=0; i < numLettersNeeded; i++) {
			int numLettersLeft = bag.size();
			if (numLettersLeft > 0) {
				int random = (int) (Math.random() * numLettersLeft);
				String l = bag.get(random);
				hand.add(l);
				b.useLettersBoard(l);
			}
		}	
	}
	
	/**
	 * @return the Player's hand
	 */
	public ArrayList<String> viewHand() {
		return hand;
	}
	
	/**
	 * @return the Player's current score
	 */
	public int getScore() {
		return currentScore;
	}
	
	/**
	 * Removes from Player's hand the letters needed to spell the optimal word
	 */
	private void useLettersHand(String word, int sri, int sci, int eri, int eci, Board b) {
		ArrayList<String> needed = b.getLettersNeeded(hand, word, sri, sci, eri, eci, b);
		for (int i=0; i<needed.size(); i++) {
			hand.remove(needed.get(i));
		}
	}

	/**
	 * Plays a word on the Board, i.e.: 
	 * - takes the letters out the the Player's hand
	 * - adds the word to the Board
	 * - increases the Player's total points as deserved
	 * - clears any special letter/word scores at the indexes
	 * 	 where the Player just placed the word
	 */
	public void playWord(String word, int sri, int sci, int eri, int eci, Board b) {
		this.useLettersHand(word, sri, sci, eri, eci, b);
		b.addWord(word, sri, sci, eri, eci);
		int points = b.wordPoints(word, sri, sci, eri, eci);
		currentScore += points;
		b.clearCoefficients(sri, sci, eri, eci);
	}
	
	/**
	 * Sets the Player's name when passed a String:
	 * @param n (name)
	 */
	public void setName(String n) {
		name += n;
	}

	/**
	 * @return the Player's name
	 */
	public String getName() {
		return name;
	}

}