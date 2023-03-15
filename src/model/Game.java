package model;

import java.util.Random;

public class Game {

	private Board<TileNode> board;
	private Player player;
	private GameObject gameObject;
	private Random rand;
	private ScoreTree<TreeNode> scoreTree;
	private TurnSystem turnSystem;

	public Game(int rows, int columns) {
		board = new Board<TileNode>(rows, columns);
		scoreTree = new ScoreTree<TreeNode>();
		turnSystem = new TurnSystem();
	}

	//public String displayBoard() {}


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

