/**
 * @author MichaelPinkham
 */

import java.io.IOException;

public class OWTester {
	
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
	
	}
}
