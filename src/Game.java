/**
 * @author MichaelPinkham
 */


import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Game {

	private Scanner in; 
	private Board b;
	private Dictionary d;
	private ArrayList<Player> playerList;

	public Game (String[] args) throws IOException {
		in = new Scanner(System.in);
		d = new Dictionary(args);
		b = new Board();
		playerList = new ArrayList<Player>();
	}

	/**
	 * Plays a Scrabble game with up to 4 players
	 */
	public void play() {
		boolean again = true;
		while (again) {
			d.fillDict();
			b.fillSB(); 
			b.fillBag();

			System.out.println("Welcome to Scrabble-Engine!");
			System.out.println("How many players do you want?" 
					+ " (Game supports up to 10 players.)");
			
			int numPlayers = in.nextInt();
			while (numPlayers > 10) {
				numPlayers = Math.floorDiv(numPlayers, 10);
			}
			System.out.println("Game will accept "+numPlayers+" players.");
			
			if (numPlayers > 1) {
				this.multiPlayer(numPlayers);
			} 
			else {
				System.out.println("Have fun playing the computer!");
				this.onePlayer();
			}
			
			System.out.println("Would you like more help? (y/n)");
			String ch1 = in.next();
			if (ch1.equals("n")) {
				again = false;
				System.out.println("Goodbye!");
			} else {
				again = true;
			}
		}
	}
	
	/**
	 * Takes a turn for a Player, i.e.: 
	 * - gets an optimalWord given his/her hand
	 * - plays that word on the Board
	 * - prints the Board to the Player/user
	 */
	private void takeTurn(Player p) {
		String[] ow = b.getOptimalWord(p, d);
		for (int m=0; m<6; m++) {
			System.out.println(ow[m]);
		}
		
		p.playWord(ow[0], Integer.parseInt(ow[2]), Integer.parseInt(ow[3]), 
			Integer.parseInt(ow[4]), Integer.parseInt(ow[5]), b);
		
		b.printBoardUpper();
	}
	
	/**
	 * Adds a Player p to the Game's set of Players
	 */
	private ArrayList<Player> addPlayer(Player p) {
		playerList.add(p);
		return playerList;
	}
	
	/**
	 * @return the point total of the Player with the most points
	 */
	private int maxPoints() {
		int maxPoints = playerList.get(0).getScore();	
		for (int i=0; i<playerList.size(); i++) {
			if (playerList.get(i).getScore() > maxPoints) {
				maxPoints=(playerList.get(i).getScore());
			}
		}
		return maxPoints;
	}
	
	/**
	 * @return the winning Player(s)
	 */
	private ArrayList<Player> getWinners() {
		ArrayList<Player> winners = new ArrayList<Player>();
		for (int i=0; i<playerList.size(); i++) {
			if (playerList.get(i).getScore() == this.maxPoints()) {
				winners.add(playerList.get(i));
			}
		}
		return winners;
	}

	/**
	 * Assigns a random name to each player in the game
	 * @param playerNames
	 */
	private void assignNamesToPlayers(ArrayList<String> playerNames) {
		int numPlayers = playerNames.size();
		ArrayList<Boolean> nameUsed = new ArrayList<Boolean>(numPlayers);
		for (int i=0; i<numPlayers; i++)  {
			nameUsed.add(false);
		}
		int counter = 0;
		while (nameUsed.contains(false)){
			int random = (int) (Math.random() * numPlayers);
			if (nameUsed.get(random)==false){ 
				playerList.get(counter).setName(playerNames.get(random));
				nameUsed.set(random, true);
				counter++;
			}
		}
			
		
	}
	
	/**
	 * Plays a single-player game v. the computer
	 */
	private void onePlayer() {
		Player p1 = new Player();
		this.addPlayer(p1);
		System.out.println("What's your name?");
		if (in.hasNext()) {
			String name = in.next();
			p1.setName(name);
		}
		else {
			p1.setName("Player1");
		}
		
		Player cpu = new Player();
		this.addPlayer(cpu);
		cpu.setName("Computer");
		
		p1.fillHand(b);
		cpu.fillHand(b);
		
		System.out.println(p1.getName() + "'s turn.");
		this.takeTurn(p1);
		System.out.println(p1.getName() + "'s current score: "+p1.getScore());
		p1.fillHand(b);
		
		
		while (p1.viewHand().size() > 0 || cpu.viewHand().size() > 0) { //while
			
			if(cpu.viewHand().size() > 0) {
				this.takeTurn(cpu);
				System.out.println(cpu.getName()+"'s current score: "+cpu.getScore());
				System.out.println();
				cpu.fillHand(b);
			}
			
			if(p1.viewHand().size() > 0) {
				this.takeTurn(p1);
				System.out.println(p1.getName()+"'s current score: "+p1.getScore());
				System.out.println();
				p1.fillHand(b);
			}
		}
		
		System.out.println("Game over!");
		System.out.println("And the winner(s): ");
		for (int i=0; i<this.getWinners().size(); i++) {
			System.out.println(this.getWinners().get(i).getName());
		}
		
		System.out.println("Would you like to play again? (y/n)");
		String ch1 = in.next();
		if (!ch1.equals("n")) {
			this.play();
		}
	}

	/**
	 * @return true if a player has letters left
	 */
	private boolean canPlay() {
		for (int i=0; i<playerList.size(); i++) {
			if (playerList.get(i).viewHand().size()>0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Plays a game with multiple players
	 * @param numPlayers
	 */
	private void multiPlayer(int numPlayers) {
		ArrayList<String> playerNames = new ArrayList<String>();
		System.out.println("What are your names? (Enter the first, "
				+ "hit 'Enter', and enter the second.)");
		
		for (int i=0; i<numPlayers; i++) {
			Player p = new Player();
			this.addPlayer(p);
			p.fillHand(b);
			String name;
			if (in.hasNext()) {
				name = in.next();
				playerNames.add(name);
			}
		}
		this.assignNamesToPlayers(playerNames);
			
		while (this.canPlay()) { 
			for (int i=0; i<playerList.size(); i++) {
				if(playerList.get(i).viewHand().size() > 0) {
					System.out.println(playerList.get(i).getName()+"'s turn.");
					this.takeTurn(playerList.get(i));
					System.out.println(playerList.get(i).getName()
							+ "'s current score: "
							+ playerList.get(i).getScore());
					System.out.println();
					playerList.get(i).fillHand(b);
				}
			}
		}
		
		System.out.println("Game over!");
		System.out.println("And the winner(s): ");
		for (int i=0; i<this.getWinners().size(); i++) {
			System.out.println(this.getWinners().get(i).getName());
		}
		
		System.out.println("Would you like to play again? (y/n)");
		String ch = in.next();
		if (!ch.equals("n")) {
			this.play();
		}
	}
}

	
	

