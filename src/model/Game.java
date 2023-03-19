package model;

import java.util.ArrayList;
import java.util.Random;

public class Game {

	private Board<TileNode> board;
	private Random rand;
	private ScoreTree<TreeNode> scoreTree;
	private TurnSystem turnSystem;
	private final String[] snakeName = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	private final char[] playerName = { '*', '!', 'O', 'X', '%', '$', '#', '+', '&'};

	public Game(int rows, int columns) {
		board = new Board<TileNode>(rows, columns);
		scoreTree = new ScoreTree<TreeNode>();
		turnSystem = new TurnSystem();
	}

	public char getCurrentPlayerName(){
		return turnSystem.getCurrentPlayer().getSymbol();
	}

	public boolean isPlayerNameTaken(char name){
		return turnSystem.isNameTaken(name);
	}

	public void nextTurn(){
		turnSystem.nextTurn();
	}

	public boolean isGameOver(){
		return turnSystem.isGameOver(board.getSize());
	}

	public void deleteAll() {
		board.deleteAll();
		board = null;
		turnSystem.deleteAll();
	}

	//public boolean checkOverlap(int start, int end) {}


	public void addPlayer(char symbol) {
		turnSystem.addPlayer(symbol);
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

	public void setScore(long time) {
		long score = (600-time)/6;
		scoreTree.addNode(time);
	}
}