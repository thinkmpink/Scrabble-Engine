/**
 *  @author: NickAckerman, MichaelPinkham
 */
import java.util.ArrayList;

public class Board {

	private final int ROWS;
	private final int COLUMNS;
	private char[][][] scrabbleBoard;
	private char[][][] boardTemplate;
	private ArrayList<String> bag;

	public Board() {
		ROWS = 15;
		COLUMNS = 15;
		scrabbleBoard = new char[ROWS][COLUMNS][2];
		boardTemplate = new char[ROWS][COLUMNS][2];
		bag = new ArrayList<String>(100);
	}

	
	
	
	
	
	
	/*
	 * BAG METHODS
	 */
	
	/**
	 * Fills the "Scrabble bag" with letters
	 */
	public void fillBag() {
		for (int i = 0; i < 3; i++) {
			bag.add("e");// 12x the letter 'e'
			bag.add("e");
			bag.add("e");
			bag.add("e");
			bag.add("a");// 9x 'a'
			bag.add("a");
			bag.add("a");
			bag.add("i");// 9x 'i'
			bag.add("i");
			bag.add("i");
			bag.add("n");// 6x 'n'
			bag.add("n");
			bag.add("r");// 6x 'r'
			bag.add("r");
			bag.add("t");// 6x 't'
			bag.add("t");
			bag.add("g");// 3x 'g'
		}
		for (int j = 0; j < 2; j++) {
			bag.add("o");// 8x the letter 'o'
			bag.add("o");
			bag.add("o");
			bag.add("o");
			bag.add("l");// 4x the letter 'l'
			bag.add("l");
			bag.add("s");// 4x the letter 's'
			bag.add("s");
			bag.add("u");// 4x the letter 'u'
			bag.add("u");
			bag.add("d");// 4x the letter 'd'
			bag.add("d");
			bag.add("b");
			bag.add("c");
			bag.add("m");
			bag.add("p");
			bag.add("f");
			bag.add("h");
			bag.add("v");
			bag.add("w");
			bag.add("y");
		}
		bag.add("k");
		bag.add("j");
		bag.add("x");
		bag.add("q");
		bag.add("z");

	}
	
	/**
	 * Takes a letter out of the "bag"
	 */
	public void useLettersBoard(String letter) {
		bag.remove(letter);
	}
	
	/**
	 * @return the bag
	 */
	public ArrayList<String> getBag() {
		return bag;
	}
	
	/**
	 * @return the number of letters left in the bag
	 */
	public int lettersLeft() {
		return bag.size();
	}
	
	
	
	
	
	
	
	
	/*
	 * SIMPLE BOARD-INTERACTIONS METHODS
	 */
	
	/**
	 * Fills the Scrabble Board with hyphens on both
	 * levels of the 2d array, and
	 * - Fills the "lower" array (char[ROWS][COLUMNS][1])
	 *   with double and triple letter/word scores
	 */
	public void fillSB() {

		// filling the array with '-'s, which are distinct from the letters I'll
		// later add
		for (int i = 0; ROWS > i; i++) {
			for (int j = 0; COLUMNS > j; j++) {
				for (int k = 0; 2 > k; k++) {
					scrabbleBoard[i][j][k] = '-';
				}
			}
		}

		/*
		 * adding characters to the deeper of the two 2-d arrays; score 'a': 2x
		 * letter score score 'b': 3x letter score score'c': 2x word score score
		 * 'd': 3x word score
		 */
		scrabbleBoard[0][3][1] = 'a';
		scrabbleBoard[0][11][1] = 'a';
		scrabbleBoard[14][3][1] = 'a';
		scrabbleBoard[14][11][1] = 'a';
		scrabbleBoard[2][6][1] = 'a';
		scrabbleBoard[2][8][1] = 'a';
		scrabbleBoard[12][6][1] = 'a';
		scrabbleBoard[12][8][1] = 'a';
		//
		scrabbleBoard[3][0][1] = 'a';
		scrabbleBoard[3][7][1] = 'a';
		scrabbleBoard[3][14][1] = 'a';
		scrabbleBoard[11][0][1] = 'a';
		scrabbleBoard[11][7][1] = 'a';
		scrabbleBoard[11][14][1] = 'a';
		//
		scrabbleBoard[6][2][1] = 'a';
		scrabbleBoard[6][6][1] = 'a';
		scrabbleBoard[6][8][1] = 'a';
		scrabbleBoard[6][12][1] = 'a';
		scrabbleBoard[8][2][1] = 'a';
		scrabbleBoard[8][6][1] = 'a';
		scrabbleBoard[8][12][1] = 'a';
		//
		scrabbleBoard[7][3][1] = 'a';
		scrabbleBoard[7][11][1] = 'a';
		// now I'll do triple letter score
		scrabbleBoard[1][5][1] = 'b';
		scrabbleBoard[1][9][1] = 'b';
		scrabbleBoard[13][5][1] = 'b';
		scrabbleBoard[13][9][1] = 'b';
		//
		scrabbleBoard[5][1][1] = 'b';
		scrabbleBoard[5][5][1] = 'b';
		scrabbleBoard[5][9][1] = 'b';
		scrabbleBoard[5][13][1] = 'b';
		scrabbleBoard[9][1][1] = 'b';
		scrabbleBoard[9][5][1] = 'b';
		scrabbleBoard[9][9][1] = 'b';
		scrabbleBoard[9][13][1] = 'b';
		// now I'll do double word score
		scrabbleBoard[1][1][1] = 'c';
		scrabbleBoard[13][1][1] = 'c';
		scrabbleBoard[1][13][1] = 'c';
		scrabbleBoard[13][13][1] = 'c';
		scrabbleBoard[2][2][1] = 'c';
		scrabbleBoard[12][2][1] = 'c';
		scrabbleBoard[2][12][1] = 'c';
		scrabbleBoard[12][12][1] = 'c';

		scrabbleBoard[3][3][1] = 'c';
		scrabbleBoard[11][3][1] = 'c';
		scrabbleBoard[3][11][1] = 'c';
		scrabbleBoard[11][11][1] = 'c';
		scrabbleBoard[4][4][1] = 'c';
		scrabbleBoard[10][4][1] = 'c';
		scrabbleBoard[4][10][1] = 'c';
		scrabbleBoard[10][10][1] = 'c';
		scrabbleBoard[5][5][1] = 'c';
		scrabbleBoard[9][5][1] = 'c';
		scrabbleBoard[5][9][1] = 'c';
		scrabbleBoard[9][9][1] = 'c';
		scrabbleBoard[6][6][1] = 'c';
		scrabbleBoard[8][6][1] = 'c';
		scrabbleBoard[6][8][1] = 'c';
		scrabbleBoard[6][6][1] = 'c';
		//
		scrabbleBoard[7][7][1] = 'c';
		scrabbleBoard[8][8][1] = 'c';
		// now I'll do triple word score
		scrabbleBoard[0][0][1] = 'd';
		scrabbleBoard[0][14][1] = 'd';
		scrabbleBoard[7][0][1] = 'd';
		scrabbleBoard[7][14][1] = 'd';
		scrabbleBoard[0][7][1] = 'd';
		scrabbleBoard[14][7][1] = 'd';
		scrabbleBoard[14][0][1] = 'd';
		scrabbleBoard[14][14][1] = 'd';
	}

	/**
	 * @print the upper level of the Board 
	 */
	public void printBoardUpper() {
		System.out.println("This is the current board.");
		for (int i = 0; 15 > i; i++) {
			String boardSquare = "";
			for (int j = 0; 15 > j; j++) {
				String sb = Character.toString(scrabbleBoard[i][j][0]);
				boardSquare += sb + " ";
			}
			System.out.println(boardSquare);
		}  
		System.out.println();
	}
	
	/**
	 * @print the lower level of the Board 
	 */
	public void printBoardLower() {
		System.out.println("This is the current board with coefficients.");
		for (int i = 0; 15 > i; i++) {
			String boardSquare = "";
			for (int j = 0; 15 > j; j++) {
				String sb = Character.toString(scrabbleBoard[i][j][1]);
				boardSquare += sb + " ";
			}
			System.out.println(boardSquare);
		}  
		System.out.println();
	}
	
	/**
	 * adds a word to the board
	 */
	public void addWord(String word, int sri, int sci, int eri, int eci) {

		if (this.isHoriz(sci, eci)) {
			for (int j = 0; j < word.length(); j++) {
				scrabbleBoard[sri][sci++][0] = word.charAt(j);
			}
		}

		else {
			for (int j = 0; word.length() > j; j++) {
				scrabbleBoard[sri++][sci][0] = word.charAt(j);
			}
		}
	}

	/**
	 * @return a character from upper 2-d array
	 */
	public char returnChar(int r, int c) {
		return scrabbleBoard[r][c][0];
	}
	
	/**
	 * @return the Board
	 */
	public char[][][] returnScrabbleBoard() {
		return scrabbleBoard;
	}
	
	/**
	 * @return true if word is horizontal
	 */
	private boolean isHoriz (int sci, int eci){
		String SCI = String.valueOf(sci);
		String ECI = String.valueOf(eci);
		if(SCI.equals(ECI)) {
			return false;
		}
		else { 
			return true;
		}
	}

	/**
	 * Concatenates an ArrayList of chars into a single String
	 * @param list
	 * @return String word
	 */
	public String listToWord(ArrayList<Character> list){
		String word = "";
		for(int i = 0; i < list.size(); i++){
			String letter;
			letter = String.valueOf(list.get(i));
			word = word.concat(letter);
		}
		return word;
	}
	
	/**
	 * Updates the Board template to match the current ScrabbleBoard (Board)
	 */
	public void updateBoardTemplate(){
		 for(int i = 0; i < scrabbleBoard.length; i++){
			 for(int j = 0; j < scrabbleBoard[0].length; j++){
				 boardTemplate[i][j][0] = scrabbleBoard[i][j][0];
			 }
		 }
	}

	/**
	 * @return the Board template
	 */
	public char[][][] getBoardTemplate(){
		return boardTemplate;
	}
	
	/**
	 * Adds a word to boardTemplate without checking whether it's valid
	 * @param word
	 * @param sri
	 * @param sci
	 * @param eri
	 * @param eci
	 */
	public void addWordNaive(String word, int sri, int sci, int eri, int eci) {
		if (!this.isHoriz(sci, eci)) { 
			for (int j = 0; j < word.length(); j++) {
				boardTemplate[sri++][sci][0] = word.charAt(j);
			}
		} else { 
			for (int j = 0; word.length() > j; j++) {
				boardTemplate[sri][sci++][0] = word.charAt(j);
			}
		}
	}

	/**
	 * 
	 * @return "true" if the Board has no letters on it
	 */
	private boolean isEmpty() {
		for (int r=0; r < ROWS; r++) {
			for (int c=0; c < COLUMNS; c++) {
				if (!(scrabbleBoard[r][c][0] == '-')) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Iterates through the Board and returns the first empty spot
	 * @return the first empty spot as an array [row, column]
	 */
	private int[] getEmptySpot() {
		int[] spot = new int[2];
		spot[0] = 0;
		spot[1] = 0;
		for (int r=0; r<ROWS; r++) {
			for (int c=0; c<COLUMNS; c++) {
				if (scrabbleBoard[r][c][0]=='-'){
					spot[0] = r;
					spot[1] = c;
					break;
				}
			}

		}
		return spot;
	}
	

	
	
	

	/*
	 * VALIDWORD METHODS
	 */
	
	/**
	 * @return true if word is valid
	 */
	public boolean validWord(ArrayList<String> lettersPlayerHas, String word,
			int sri, int sci, int eri, int eci, Dictionary d) {

		if (!(this.validIndexes(sri, sci, eri, eci))) {
			return false;
		}
		
		if (!(this.wordFits(word, sri, sci, eri, eci))) {
			return false;
		}
		
		if (!(this.canSpell(lettersPlayerHas, word, sri, sci, eri, eci))){
			return false;
		}
		
		if (!(this.wLenMatchIndexes(word, sri, sci, eri, eci))) {
			return false;
		}
		
		if (!(this.unusedWord(word, sri, sci, eri, eci))) { 
			return false;
		}
		
		if (!(this.canAttach(sri, sci, eri, eci))) {
			return false;
		}
		
		if (!(this.newWordsExist(word, sri, sci, eri, eci, d))) {
			return false;
		}

		return true; 	
	}

	/**
	 * @return "true" if the first move is valid
	 * @param lettersPlayerHas
	 * @param word
	 * @param sri
	 * @param sci
	 * @param eri
	 * @param eci
	 * @param d
	 */
	public boolean firstMoveValid(ArrayList<String> lettersPlayerHas, String word,
			int sri, int sci, int eri, int eci, Dictionary d) {

		if (!(this.validIndexes(sri, sci, eri, eci))) {
			return false;
		}
		
		if (!(this.includesCenter(sri, sci, eri, eci))) {
			return false;
		}
		
		if (!(this.wordFits(word, sri, sci, eri, eci))) {
			return false;
		}
		
		if (!(this.canSpell(lettersPlayerHas, word, sri, sci, eri, eci))){
			return false;
		}
		
		if (!(this.wLenMatchIndexes(word, sri, sci, eri, eci))) {
			return false;
		}
		
		if (!(this.unusedWord(word, sri, sci, eri, eci))) { 
			return false;
		}	
		return true; 	
	}
	
	/**
	 * @return true if indexes are nonnegative and fit on 15x15 board
	 */
	private boolean validIndexes(int sri, int sci, int eri, int eci) {
		if (sri <= eri && sci <= eci && sri > (-1) && sci > (-1) &&
				eci < 15 && eri < 15) {
			return true;
		}
		return false;
		
	}
	
	/**
	 * @return "true" if the word's length matches the provided indexes
	 * @param word
	 * @param sri
	 * @param eri
	 * @param sci
	 * @param eci
	 */
	private boolean wLenMatchIndexes(String word, int sri, int sci, int eri, int eci) {
		if(this.isHoriz(sci, eci)) {
			if(this.wLenMatchIndexH(word, sci, eci)) {
				return true;
			}
		}
		else {
			if(this.wLenMatchIndexV(word, sri, eri)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return true if index input matches word length (for vertical)
	 */
	private boolean wLenMatchIndexV (String word, int sri, int eri) {
		if (((eri - sri) + 1) == word.length()){
			return true;
		}
		return false;
	}
	
	/**
	 * @return true if index input matches word length (for horiz)
	 */
	private boolean wLenMatchIndexH (String word, int sci, int eci) {
		if (((eci - sci) + 1) == word.length()){
			return true;
		}
		return false;
	}

	/**
	 * Checks whether the given indexes pass through the center of the Board
	 * @param sri
	 * @param sci
	 * @param eci
	 * @param eri
	 * @return "true" if indexes pass through the center
	 */
	private boolean includesCenter (int sri, int sci, int eri, int eci)  {
		boolean includesCenter = false;
		final int center = 7;
		if (sri <= center) {
			if (sci <= center) {
				if (eri >= center) {
					if (eci >= center) {
						includesCenter = true;
					}
				}
			}
		}
		return includesCenter;
	}
	
	/**
	 * @return an ArrayList of letters in a dictionary entry 
	 * that may be placed on the board
	 */
	private ArrayList<String> lettersNeeded (String word,
			int sri, int sci, int eri, int eci) {		
		
		ArrayList<String> lettersNeeded = new ArrayList<String>();

		if (this.isHoriz(sci, eci)) {			
			for (int i = 0; i < ((eci-sci)+1); i++) {
				String dictLetter = String.valueOf(word.charAt(i));
				String boardLetter = String.valueOf(scrabbleBoard[sri][sci+i][0]);
				if (!(boardLetter.equals(dictLetter))) {
					lettersNeeded.add(dictLetter);
				}
			}
		}
		else {
			for (int k = 0; k < ((eri-sri)+1); k++) {
				String dictLetter = String.valueOf(word.charAt(k));
				String boardLetter = String.valueOf(scrabbleBoard[sri+k][sci][0]);
				if (!(boardLetter.equals(dictLetter))) { 
					lettersNeeded.add(dictLetter);
				}
			}
		}
		return lettersNeeded;
	}  
	
	/**
	 * Calls lettersNeeded
	 * @param lettersPlayerHas
	 * @param word
	 * @param sri
	 * @param sci
	 * @param eri
	 * @param eci
	 * @param b
	 * @return lettersNeeded
	 */
	public ArrayList<String> getLettersNeeded (String word, 
			int sri, int sci, int eri, int eci, Board b) {
		return b.lettersNeeded(word, sri, sci, eri, eci);
	}
	
	/**
	 * @return false if letters conflict with letters already on the board
	 */
	private boolean wordFits(String word,
			int sri, int sci, int eri, int eci){
		
		if (this.isHoriz(sci, eci)) {
			for (int i = 0; i < (eci - sci + 1); i++) { 				
				char boardLtr = scrabbleBoard[sri][sci+i][0];
				if (word.charAt(i) != boardLtr) {
					if (boardLtr != '-') {
						return false;
					}
				}
			}
		} 
		else {
			for (int k = 0; k < (eri - sri + 1); k++) { 				
				char boardLtr = scrabbleBoard[sri+k][sci][0];
				if (word.charAt(k) != boardLtr) {
					if (boardLtr != '-') {
						return false; 
					}
				}
			}
		}
		return true;
	}

	/**
	 * @return false if the word is already on the board
	 */
	private boolean unusedWord(String word,
			int sri, int sci, int eri, int eci) {
		return this.lettersNeeded(word, sri, sci, eri, eci).size()>0;
	} 

	/**
	 * @return true when player can spell the dictionary entry
	 */
	private boolean canSpell(ArrayList<String> lettersPlayerHas, String word, 
			int sri, int sci, int eri, int eci) {
		ArrayList<String> lettersNeeded = this.lettersNeeded(word, sri, sci, eri, eci);
		
		
		ArrayList<String> hand = new ArrayList<String>();
		for (int j = 0; j<lettersPlayerHas.size(); j++) {
			hand.add(lettersPlayerHas.get(j));
		}
		
		if (lettersNeeded.size() > 7){
			return false; //if the board needs more letters than the player has
		}
		
		for (int i = 0; i < lettersNeeded.size(); i++) {
			if (!(hand.contains(lettersNeeded.get(i)))) {
				return false;
			}	
			hand.remove(lettersNeeded.get(i));
		}
		return true;
	}
	
	/**
	 * @return true if the player needs to use all his/her letters to spell the word
	 * @param lettersPlayerHas
	 * @param word
	 * @param sri
	 * @param sci
	 * @param eri
	 * @param eci
	 */
	private boolean usesAllPlayerLetters(String word,
			int sri, int sci, int eri, int eci) {
		return this.lettersNeeded(word, sri, sci, eri, eci).size()==7;
	}

	
	
	


	
	
	
	/*
	 * OPTIMAL-WORD METHODS
	 */
	
	/** 
	 * @return array "optimalWord" containing:
	 * (1) A word, (2) horizontal or vertical,
	 * (3) SRI, (4) SCI, (5) ERI, (6) ECI
	 * @param Player p
	 * @param Dictionary d
	 */
	private String[] optimalWord(Player p, Dictionary d) {
		
		String[] optimalWord = new String[6];		
		for(int i=0; i<optimalWord.length; i++){
			optimalWord[i] = ""; 
		}
		
		ArrayList<String> hand = p.viewHand();
		System.out.print(p.getName()+"'s hand: "+hand);
		System.out.println();
		
		ArrayList<String> dictionary = d.returnDictionary();
		
		int highestPoints = 0;
		int pointsH = 0;
		int pointsV = 0;
		for (int r = 0; r < ROWS; r++) { //ROWS
			for (int c = 0; c < COLUMNS; c++) { //COLUMNS
				for (int k = 0; k<dictionary.size(); k++) {
					String currentWord = dictionary.get(k);
					int wLen = currentWord.length();
					String SRI = Integer.toString(r);
					String SCI = Integer.toString(c);
					int horizIndex = c + wLen - 1;
					int verticalIndex = r + wLen - 1;

					String hiStr = Integer.toString(horizIndex);
					String viStr = Integer.toString(verticalIndex);
					if (this.isEmpty()) {
						if (this.firstMoveValid(hand, currentWord, r, c, r, horizIndex, d)) {
							pointsH = this.wordPoints(hand, currentWord, r, c, r, horizIndex);
						}
						if (this.firstMoveValid(hand, currentWord, r, c, verticalIndex, c, d)) {
							pointsV = this.wordPoints(hand, currentWord, r, c, verticalIndex, c);
						}
					}
					else {
						if (this.validWord(hand, currentWord, r, c, r, horizIndex, d)) {
							pointsH = this.wordPoints(hand, currentWord, r, c, r, horizIndex); //verticalIndex
						}
						if (this.validWord(hand, currentWord, r, c, verticalIndex, c, d)) {
							pointsV = this.wordPoints(hand, currentWord, r, c, verticalIndex, c);
						}
					}	

					// comparing these two ints to current largest value
					if (pointsH > highestPoints) {
						highestPoints = pointsH;

						System.out.println(currentWord + highestPoints);

						optimalWord[0] = currentWord;
						optimalWord[1] = "horizontal";
						optimalWord[2] = SRI;
						optimalWord[3] = SCI;
						optimalWord[4] = SRI;
						optimalWord[5] = hiStr;
					}

					if (pointsV > highestPoints) {

						highestPoints = pointsV;
						System.out.println(currentWord + highestPoints);

						optimalWord[0] = currentWord;
						optimalWord[1] = "vertical";
						optimalWord[2] = SRI;
						optimalWord[3] = SCI;
						optimalWord[4] = viStr;
						optimalWord[5] = SCI;
					}

				}
			}
		}
		if(optimalWord[0]=="") { //if there is no optimal word, set it to the blank
			int[] emptySpot = this.getEmptySpot();
			optimalWord[0]="-"; //and return and empty spot on the Board as the indexes
			optimalWord[1]="spot";
			optimalWord[2] = Integer.toString(emptySpot[0]);
			optimalWord[3] = Integer.toString(emptySpot[1]);
			optimalWord[4] = Integer.toString(emptySpot[0]);
			optimalWord[5] = Integer.toString(emptySpot[1]);
			System.out.println("no optimal word");
		}
		return optimalWord;

	}
	
	public String[] getOptimalWord(Player p, Dictionary d) {
		  return this.optimalWord(p, d);
	}



	
	
	
	
	
	/*
	 * POINTS METHODS
	 */
	
	/**
	 *  @return the point value of a given letter
	 */
	private int letterPoints(String letter) {

		int points = 0;
		if (letter.equals("a") || letter.equals("e") || letter.equals("i")
				|| letter.equals("o") || letter.equals("n")
				|| letter.equals("r") || letter.equals("t")
				|| letter.equals("l") || letter.equals("s")
				|| letter.equals("u")) {
			points += 1;
		} else if (letter.equals("d") || letter.equals("g")) {
			points += 2;
		} else if (letter.equals("b") || letter.equals("c")
				|| letter.equals("m") || letter.equals("p")) {
			points += 3;
		} else if (letter.equals("f") || letter.equals("h")
				|| letter.equals("v") || letter.equals("w")
				|| letter.equals("y")) {
			points += 4;
		} else if (letter.equals("k")) {
			points += 5;
		} else if (letter.equals("j") || letter.equals("x")) {
			points += 8;
		} else if (letter.equals("q") || letter.equals("z")) {
			points += 10;
		} else { // blank tile, neatness
			points += 0;
		}
		return points;
	}
	
	/** 
	 * Makes an arrayList of coefficients in which each list entry's
	 * coefficient corresponds to the the letter score on the board.
	 */ 
	private ArrayList<Integer> letterCoefficients(int sri,
			int sci, int eri, int eci) {

		ArrayList<Character> coeffChar = new ArrayList<Character>(10);
		ArrayList<Integer> coeff = new ArrayList<Integer>(10);

		if (this.isHoriz(sci, eci)) {
			for (int c = sci; c < (eci + 1); c++) { //eci + 1
				coeffChar.add(scrabbleBoard[sri][c][1]);
			}
		} else {
			for (int r = sri; r < (eri + 1); r++) { //eri + 1
				coeffChar.add(scrabbleBoard[r][sci][1]);
			}
		}

		for (int i = 0; i < coeffChar.size(); i++) {

			if (coeffChar.get(i) == 'a') {
				coeff.add(2);
			} else if (coeffChar.get(i) == 'b') {
				coeff.add(3);
			} else {
				coeff.add(1);
			}
		}
		return coeff;
	}

	/**
	 * @return a coefficient that represents a word's total multiple word scores
	 */
	private int wordCoefficients(int sri, int sci, int eri, int eci) {
		int wordCoeff = 1;
		ArrayList<Character> coeffChar = new ArrayList<Character>(10);

		if (this.isHoriz(sci, eci)) {
			for (int c = sci; c < (eci + 1); c++) {
				coeffChar.add(scrabbleBoard[sri][c][1]);
			}
		} else {
			for (int r = sri; r < (eri + 1); r++) {
				coeffChar.add(scrabbleBoard[r][sci][1]);
			}
		}

		for (int i = 0; i < coeffChar.size(); i++) {
			if (coeffChar.get(i) == 'c') {
				wordCoeff *= 2;
			} else if (coeffChar.get(i) == 'd') {
				wordCoeff *= 3;
			} else {
				wordCoeff *= 1;
			}
		}
		return wordCoeff;
	}

	/**
	 * Adds a bonus for using all 7 letters in a Player's hand
	 * @param hand
	 * @param word
	 * @param sri
	 * @param sci
	 * @param eri
	 * @param eci
	 * @return +50 points if Player gets bonus, otherwise +0 points
	 */
	private int bonus(ArrayList<String> hand, String word, 
			int sri, int sci, int eri, int eci) {
		int bonus = 0;
		if (this.usesAllPlayerLetters(word, sri, sci, eri, eci)) {
			bonus += 50;
		}
		return bonus;
	}
	
	/**
	 * Adds letter points in word, multiplies by letter & word coefficients
	 * @return total points for a word
	 */
	private int setWordPoints(ArrayList<String> hand, String word, int sri, int sci, int eri, int eci) {
		int points = 0;
		ArrayList<Integer> lCoefficients = new ArrayList<Integer>();
		for (int j = 0; j<this.letterCoefficients(sri, sci, eri, eci).size(); j++) {
			lCoefficients.add(this.letterCoefficients(sri, sci, eri, eci).get(j));
		}
		int wCoefficients = this.wordCoefficients(sri, sci, eri, eci);
		int[] letterValue = new int[15];
		
		int bonus = this.bonus(hand, word, sri, sci, eri, eci);

		for (int i = 0; i < word.length(); i++) {
			letterValue[i] = letterPoints(word.substring(i, i+1));
			letterValue[i] *= lCoefficients.get(i);
			points += letterValue[i];
		}
		points *= wCoefficients;
		points += bonus;

		return points;
	}

	public int wordPoints(ArrayList<String> hand, String word, int sri, int sci, int eri, int eci) {
		return this.setWordPoints(hand, word, sri, sci, eri, eci);
	}
	
	
	/**
	 * Clears the multiple letter and word scores
	 * so that they may only be used once per game
	 */
	public void clearCoefficients(int sri, int sci, int eri, int eci) {
		for (int r = sri; r < eri + 1; r++) {
			for (int c = sci; c < eci + 1; c++) {
				scrabbleBoard[r][c][1] = '-';
			}
		}
	}
	
	
	
	
	
	
	
	
	/*
	 * COMPLEX BOARD-INTERACTIONS METHODS
	 */
	
	/**
	 * @return "true" if at least one letter can attach to a given spot on the Board
	 * @param sri
	 * @param sci
	 * @param eri
	 * @param eci
	 */
	private boolean canAttach(int sri, int sci, int eri, int eci) {
		this.updateBoardTemplate();
		if (this.letterAdjacent(sri, sci, eri, eci) || this.letterWithin(sri, sci, eri, eci)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks whether there is a letter on the Board between the given indexes
	 * @param sri, sci, eri, eci
	 * @return "true" if there is at least one letter on the Board between
	 * the given indexes.
	 */
	private boolean letterWithin(int sri, int sci, int eri, int eci) {
		for (int r = sri; r < eri+1; r++) {
			for (int c = sci; c < eci+1; c++) {
				if(scrabbleBoard[r][c][0] != '-') {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if there are words adjacent to a given word on a board
	 * @param sri
	 * @param sci
	 * @param eri
	 * @param eci
	 * @return "true" iff there are letters adjacent to the provided indexes
	 */
	public boolean letterAdjacent(int sri, int sci, int eri, int eci){
		if(!(this.endsEmpty(sri, sci, eri, eci))){	
			return true;
		}
		if(!(this.longSideEmpty(sri, sci, eri, eci))){
			return true;
		}
		return false;
	}
	
	/**
	 * Checks whether the two board spots next to each start/end index
	 * are empty, i.e. have hyphens stored in the board array at the 
	 * upper level
	 * @param sri
	 * @param sci
	 * @param eri
	 * @param eci
	 * @param horizontal
	 * @return "true" if ends are empty
	 */
	public boolean endsEmpty(int sri, int sci, int eri, int eci){
		boolean endsEmpty = true;
		if(this.isHoriz(sci, eci)){
			if (sci > 0) {
				if(boardTemplate[sri][sci-1][0] != '-') {
					endsEmpty = false;
				}
			}
			if (eci < 14) {
				if (boardTemplate[sri][eci+1][0] != '-') {
					endsEmpty = false;
				}
			}
		}
		else{
			if (sri > 0) {
				if(boardTemplate[sri-1][sci][0] != '-') {
					endsEmpty = false;
				}
			}
			if (eri < 14) {
				if (boardTemplate[eri+1][sci][0] != '-') {
					endsEmpty = false;
				}
			}
		}
		//System.out.println("ends empty: "+ endsEmpty);
		return endsEmpty;
	}
	
	/**
	 * Checks whether the "long sides" above and below the word
	 * are empty (for the full length of the word), 
	 * i.e. have hyphens stored in the board array at the upper level
	 * @param sri
	 * @param sci
	 * @param eri
	 * @param eci
	 * @param horizontal
	 * @return "true" if the "long sides" above and below the word are empty
	 */
	public boolean longSideEmpty(int sri, int sci, int eri, int eci){
		boolean longSideEmpty = true;
		if(this.isHoriz(sci, eci)){
			for(int i = 0; i < (eci-sci+1); i++){
				if (sri < 14) {
					if(boardTemplate[sri+1][sci+i][0] != '-') {
						longSideEmpty = false;
					}
				}
				if (sri > 0) {
					if (boardTemplate[sri-1][sci+i][0] != '-') {
						longSideEmpty = false;
					}
				}
			}
		}
		else{
			for(int i = 0; i < (eri-sri+1); i++){
				if (sci < 14) {
					if(boardTemplate[sri+i][sci+1][0] != '-') {
						longSideEmpty = false;
					}
				}
				if (sci > 0) {
					if (boardTemplate[sri+i][sci-1][0] != '-') {
						longSideEmpty = false;
					}
				}
			}
		}
		//System.out.println("long side empty: " + longSideEmpty);
		return longSideEmpty;
	}
	
	/**
	 * Checks whether a letter has perpendicular letters next to it.
	 *  - Accounts for the sides of the board
	 * @param rI
	 * @param cI
	 * @param sri
	 * @param sci
	 * @param eri
	 * @param eci
	 * @return "true" if letter has no perpendicular letters next to it
	 */
	public boolean letterIsolated(int rI, int cI, int sri, int sci, int eri, int eci){
		boolean isolated = true;
		if(this.isHoriz(sci, eci)){
			if(!(rI == 0) && !(rI == 14)){
				if(scrabbleBoard[rI+1][cI][0] != '-'){
					if(scrabbleBoard[rI-1][cI][0] != '-'){
						isolated = false;
					}
				}
			}
			if(rI == 0){
				if(scrabbleBoard[rI+1][cI][0] != '-'){
					isolated = false;
				}
			}
			if(rI == 14){
				if(scrabbleBoard[rI-1][cI][0] != '-'){
					isolated = false;
				}
			}
			if(rI == sri && !(cI == 0)){
				if(scrabbleBoard[rI][cI-1][0] != '-'){
					isolated = false;
				}
			}
			if(rI == eri && !(cI == 14)){
				if(scrabbleBoard[rI][cI-1][0] != '-'){
					isolated = false;
				}
			}
			
		}
		else{
			if(!(cI == 0 && cI == 14)){
				if((scrabbleBoard[rI][cI+1][0] != '-') && (scrabbleBoard[rI][cI-1][0] != '-')){
					isolated = false;
				}
			}
			if(cI == 14){
				if(scrabbleBoard[rI][cI-1][0] != '-'){
					isolated = false;
				}
			}
			if(cI == 0){
				if(scrabbleBoard[rI][cI+1][0] != '-'){
					isolated = false;
				}
			}
			if(cI == sci && !(rI == 0)){
				if(scrabbleBoard[rI-1][cI][0] != '-'){
					isolated = false;
				}
			}
			if(cI == eci && !(rI == 14)){
				if(scrabbleBoard[rI-1][cI][0] != '-'){
					isolated = false;
				}
			}
		}
		return isolated;
	}
	

	
	/**
	 * Collects a word on the BoardTemplate given a spot on the Board 
	 * and a direction of collection
	 * @param r (row number)
	 * @param c (column number)
	 * @param horizontal (true if the collection direction is horizontal)
	 * @return a String word that has been collected from boardTemplate
	 */
	public String collectWord(int r, int c, boolean horizontal) {
		String word = "";
		if(horizontal==true) {
			int i = c;
			while (boardTemplate[r][i][0] != '-') {
				i--; //decrement to left of word
			}
			i++; //increment 1 to first letter
			while (boardTemplate[r][i][0] != '-') {
				word += boardTemplate[r][i][0];
				i++; //increment to right end of word
			}
		}
		else {			
			int i = r;
			while (boardTemplate[i][c][0] != '-') {
				i--; //decrement to top of word			
			}
			i++; //increment 1 to first letter
			while (boardTemplate[i][c][0] != '-') {
				word += boardTemplate[i][c][0];
				i++; //increment to bottom end of word
			}
		}
		return word;
	}
		
	public boolean wordsReal(ArrayList<String> words, Dictionary d) {
		for (int i=0; i<words.size(); i++) {
			if (words.get(i).length()>1) {
				if (!(d.wordInDict(words.get(i)))) {
					return false;
				}
			}
		}
		return true;
	}
		
	
	
	/**
	 * Returns the word that's formed using a letter from a newly placed word 
	 * (assuming there is such a word) on long part of word
	 *  - If there is no such word, return a blank string (e.g. "")
	 * @param word
	 * @param sri
	 * @param sci
	 * @param eri
	 * @param eci
	 * @param rI
	 * @param cI
	 * @returns a new String word
	 */
	public String perpendicularWords(String word, int sri, int sci, int eri, int eci, int rI, int cI){
				
		this.updateBoardTemplate();
		this.addWordNaive(word, sri, sci, eri, eci);
		String newWord = "";
		boolean isInHorizWord = this.isHoriz(sci, eci);
		ArrayList<Character> letterList = new ArrayList<Character>();
		if(isInHorizWord){
			int i=0;
			while((boardTemplate[rI-i][cI][0] != '-') && (rI - i > 0)){
				i++;
			}
			if(rI-i > 0) {
				i--;
			}
			int physicallyHighestRI = rI - i;
			int j=0;
			while((boardTemplate[rI+j][cI][0] != '-') && (rI + j < 14)){
				j++;
			}
			if(rI+j < 14) {
				j--;
			}
			int physicallyLowestRI = rI + j;
			for(int k = physicallyHighestRI; k < physicallyLowestRI+1; k++){
				letterList.add(boardTemplate[k][cI][0]);
			}
			newWord = this.listToWord(letterList);
		}
		else{
			int i=0;
			while((boardTemplate[rI][cI-i][0] != '-') && (cI - i > 0)){
				i++;
			}
			if(cI-i>0){
				i--;
			}
			int physicallyHighestRI = cI - i;
			int j=0;
			while((boardTemplate[rI][cI+j][0] != '-') && (cI + j < 14)){
				j++;
			}
			if(cI+j < 14) {
				j--;
			}
			int physicallyLowestRI = cI + j;
			for(int k = physicallyHighestRI; k < physicallyLowestRI+1; k++){
				letterList.add(boardTemplate[rI][k][0]);
			}
			newWord = this.listToWord(letterList);
			
		}
		return newWord;
	}
	
	/**
	 * Returns a String word parallel to the given word formed 
	 * using all the letters from a newly placed word 
	 * (assuming there is such a word);
	 *  - If there is no such word, return an empty string (e.g. "")
	 * @param word
	 * @param sri
	 * @param sci
	 * @param eri
	 * @param eci
	 * @return a String word perpendicular to the given word
	 */
	public String parallelWord(String word, int sri, int sci, int eri, int eci){
				
		this.updateBoardTemplate();
		this.addWordNaive(word, sri, sci, eri, eci);
		String newWord = "";
		ArrayList<Character> letterList = new ArrayList<Character>();
		
		if(this.isHoriz(sci, eci)){
			int i=0;
			while((boardTemplate[sri][sci-i][0] != '-') && (sci - i > 0)){
				i++; //i++ //increment i until reach the leftmost end of the new word
			}
			if(sci-i > 0) {
				i--; 
			}
			int leftRI = sci - i;
			
			int j = 0;
			while((boardTemplate[sri][sci+j][0] != '-') && (sci + j < 14)){
				j++; //increment j until reach the rightmost end of the new word
			}
			if(sci+j<14){
				j--; //m's addition 7/20
			}
			int rightRI = sci + j; //+1 m 7/21
			for(int k = leftRI; k < rightRI+1; k++){
				letterList.add(boardTemplate[sri][k][0]);
			}
			newWord = this.listToWord(letterList);
			
		}
		else{
			int i=0;
			while((boardTemplate[sri-i][sci][0] != '-') && (sri - i > 0)){
				i++; //increment i until reach the top of the word
			}
			if(sri-i > 0) {
				i--; //m's addition 7/20
			}
			int topRI = sri - i;
			int j=0;
			while((boardTemplate[sri+j][sci][0] != '-') && (sri + j < 14)){
				j++; //increment j until reach the bottom of the word
			}
			if(sri+j<14){
				j--; //m's addition 7/20
			}
			int bottomRI = sri + j; //+1 m 7/21
			for(int k = topRI; k < bottomRI+1; k++){
				letterList.add(boardTemplate[k][sci][0]);
			}
			newWord = this.listToWord(letterList);
		}
		//System.out.println(newWord + "short");
		return newWord;
	}
	
	/**
	 * Checks whether extra parallel/perpendicular words formed 
	 * by adding a given word to the Board are in the Dictionary d
	 * @param word
	 * @param sri
	 * @param sci
	 * @param eri
	 * @param eci
	 * @param d
	 * @return "true" if the dictionary contains the extra words
	 */
	public boolean newWordsExist(String word, int sri, int sci, int eri, int eci, Dictionary d) {
		
		this.updateBoardTemplate();
		boolean newWordsExist = true;
		ArrayList<String> newWords = new ArrayList<String>();
		if(this.isHoriz(sci, eci)){
			newWords.add(this.parallelWord(word, sri, sci, eri, eci));
			for(int i = 0; i < word.length(); i++){ 
				newWords.add(this.perpendicularWords(word, sri, sci, eri, eci, sri, sci + i));
			}
		}
		else{
			newWords.add(this.parallelWord(word, sri, sci, eri, eci));
			for(int i = 0; i < word.length(); i++){
				newWords.add(this.perpendicularWords(word, sri, sci, eri, eci, sri + i, sci));
			}	
		}
		
		for(int k = 0; k < newWords.size(); k++){
			if(newWords.get(k).length() > 1){
				if(!d.wordInDict(newWords.get(k))){
					newWordsExist = false;
				} // fill newWordsReal with words that
			} 	  // are actually in the dictionary
		}
		return newWordsExist;
	}
	

}



