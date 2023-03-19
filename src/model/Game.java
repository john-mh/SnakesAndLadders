package model;

import java.util.ArrayList;
import java.util.Random;

public class Game {

	private Board<TileNode> board;
	private ArrayList<GameObject> gameObject;
	private Random rand;
	private ScoreTree<TreeNode> scoreTree;
	private TurnSystem turnSystem;
	private String[] snakeName = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	private char[] playerName = { '*', '!', 'O', 'X', '%', '$', '#', '+', '&'};

	public Game(int rows, int columns) {
		board = new Board<TileNode>(rows, columns);
		scoreTree = new ScoreTree<TreeNode>();
		turnSystem = new TurnSystem();
	}

	public char getCurrentPlayerName(){
		return turnSystem.getCurrentPlayer().getSymbol();
	}

	public String printBoard(){
		StringBuilder boardString = new StringBuilder(" ");
		return printBoard(board.getRoot(), boardString, board.getColumns(), 0).toString();
	}

	private StringBuilder printBoard(TileNode root, StringBuilder board, int columns, int i) {
		board.append("[").append(root).append("]");
		if(root.getNext()!=null){
			if(i==columns){
				board.append("\n");
				i=-1;
			}
			printBoard((TileNode) root.getNext(), board, columns, i+1);
		}
		return board;
	}

	public void initializeLadders(int boardSize, int rows, int i){
		if(rows>i){

			int startS=(int)(Math.random()*((boardSize+1)-(2))-2);
			int finalS=(int)(Math.random()*((boardSize+1)-(2))-2);
			GameObject ladder = new Ladder(String.valueOf(i), startS, finalS);
			gameObject.add(ladder);
			board.addGameObject(ladder);
			initializeLadders(boardSize, rows, i+1);
		}
	}

	public void deleteAll() {
	}

	//public boolean checkOverlap(int start, int end) {}

	public boolean isNameTaken(char name){
		return false; // TODO write this method
	}

	public void addPlayer(char symbol) {
		turnSystem.addPlayer(symbol);
	}

	public void addGameObject() {
	}

	public void deleteGameObject() {
	}

	public void deletePlayer() {
	}

	public void movePlayer(int n) {
		board.movePlayer(turnSystem.getCurrentPlayer(), n);
	}

	public int throwDice() {
		return rand.nextInt(6) + 1;
	}
}

