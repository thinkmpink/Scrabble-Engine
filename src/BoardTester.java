import java.io.FileNotFoundException;

public class BoardTester {

	public static void main(String[] args) throws FileNotFoundException {

		Board b = new Board();
		b.fillSB(); // added to fill the board
		b.fillBag();
		Dictionary d = new Dictionary(args);
		d.fillDict();

		b.updateBoardTemplate();
		
		Player p = new Player();
		p.fillHandUser(b, "q", "u", "i", "x", "o", "t", "e");
		b.getOptimalWord(p, d);
	}

}
