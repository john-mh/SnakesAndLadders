package model;

import java.util.Random;

public class Game {

	private Board<TileNode> board;
	private Player player;
	private GameObject gameObject;
	private Random rand;
	private ScoreTree<TreeNode> scoreTree;
	private TurnSystem turnSystem;
	private String[] snakeName = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

	public Game(int rows, int columns) {
		board = new Board<TileNode>(rows, columns);
		scoreTree = new ScoreTree<TreeNode>();
		turnSystem = new TurnSystem();
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
			board.addSnakeOrLadder(startS, finalS);
			initializeLadders(boardSize, rows, i+1);
		}
	}

	public void deleteAll() {
	}

	public boolean checkOverlap() {
		return false; // TODO write this method
	}

	public void addPlayer() {
	}

	public void addGameObject() {
	}

	public void deleteGameObject() {
	}

	public void deletePlayer() {
	}

	public void movePlayer(int n) {
	}

	public int throwDice() {
		return rand.nextInt(6) + 1;
	}
}

