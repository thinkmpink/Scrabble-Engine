import java.io.FileNotFoundException;

public class BoardTester {

	public static void main(String[] args) throws FileNotFoundException {

		Board b = new Board();
		b.fillSB(); // added to fill the board
		b.fillBag();
		Dictionary d = new Dictionary(args);
		d.fillDict();

		Player p = new Player();
		p.setName("p");
		
		b.addWord("ax", 0, 1, 0, 2);
		b.printBoardUpper();
		
		p.fillHandUser(b, "t", "e", "x", "t");
		
	/*	b.updateBoardTemplate();
		b.addWord("melons", 3, 7, 8, 7);
		b.addWord("coax", 6, 6, 6, 9);
		b.addWord("exines", 5, 9, 10, 9);
		
		p.fillHandUser(b, "o", "o", "r", "a", "g", "i", "a"); */
		String[] ow = b.getOptimalWord(p, d);
		String[][] hooks = b.getHooks(ow[0], Integer.parseInt(ow[2]), 
			Integer.parseInt(ow[3]), Integer.parseInt(ow[4]), Integer.parseInt(ow[5]));
		for (int i=0; i<ow[0].length(); i++) {
			System.out.println("hi0: "+ hooks[i][0]);
			System.out.println("hi1: "+ hooks[i][1]);
			System.out.println("hi2: "+ hooks[i][2]);
		}
		//b.printBoardLower(); 
	}

}
