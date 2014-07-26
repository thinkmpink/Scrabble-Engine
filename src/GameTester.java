/**
 * @author MichaelPinkham
 */

import java.io.IOException;
import java.util.InputMismatchException;

public class GameTester {
	
	/**
	 * Plays a Scrabble Game (Game)
	 * @param args
	 */
	public static void main (String[] args){
		
		try {
			Game g = new Game(args);
			g.play();
		}
		
		// catches if inFile doesn't exist
		catch (IOException e) {
			System.out.println("Please try again"
				+ " with correct input file name");
		}
		
		// catches if there is no optimal word
		catch (NumberFormatException e) {
			System.out.println("Sorry, there is no"
				+ " optimal word for your hand.");
			
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please enter input"
				+ "of a type appropriate to the question");
		}
	}
}
