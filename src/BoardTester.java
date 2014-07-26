import java.io.FileNotFoundException;

public class BoardTester {

	public static void main(String[] args) throws FileNotFoundException {

		Board b = new Board();
		b.fillSB(); // added to fill the board
		b.fillBag();
		Dictionary d = new Dictionary(args);
		d.fillDict();

		b.updateBoardTemplate();
		
		b.addWordNaive("quick", 3, 4, 3, 8);
		b.addWordNaive("quite", 2, 5, 6, 5);

		//b.printBoardUpper();
		//System.out.println(b.collectWord(3, 5, true));
		//System.out.println(b.collectWord(3, 5, false));
		

	}

}
