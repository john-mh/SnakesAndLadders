package model;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Board<T extends Node>{

	private TileNode root;
	private final int size;
	private final int rows;
	private final int columns;

	public Board(int rows, int columns){
		root = new TileNode(0);
		this.rows = rows;
		this.columns = columns;
		size = rows * columns;
		generateBoard(rows, columns);
	}

	public TileNode getRoot() {
		return this.root;
	}

	public void setRoot(TileNode root) {
		this.root = root;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public void generateBoard(int rows, int columns) {
		generateBoardRecursive(root, size);
	}

	private TileNode generateBoardRecursive(TileNode currentTile, int size) {
		if (size == 0) {
			return null;
		}
		TileNode nextTile = new TileNode(currentTile.getTileNumber() + 1);
		currentTile.setNext(nextTile);
		return generateBoardRecursive(nextTile, size - 1);
	}

	public TileNode getTile(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds: " + index);
		}
		return getTileRecursive(root, index);
	}

	private TileNode getTileRecursive(TileNode currentTile, int index) {
		if (index == 0) {
			return currentTile;
		}
		if(currentTile.getNext() == null){
			return null;
		}
		else{
			return getTileRecursive((TileNode) currentTile.getNext(), index - 1);
		}
	}

	public boolean isTileOccupied(TileNode node) {
		return node.getPlayers()[0] != null;
	}

	public String getTilePlayers(TileNode node){
		StringBuilder sb = new StringBuilder();
		return getTilePlayersRecursive(sb, node, 0).toString();
	}

	private StringBuilder getTilePlayersRecursive(StringBuilder sb, TileNode node, int index) {
		if (index == node.getPlayers().length  || node.getPlayers()[index] == null) {
			return sb;
		}
		else{
			sb.append(node.getPlayers()[index].getSymbol());
			return getTilePlayersRecursive(sb, node, index + 1);
		}
	}


	public TileNode searchTileByID(int index, int id){
		TileNode currentTile = getTile(index);

		if(currentTile.getTileNumber() == id){
			return currentTile;
		}
		else if(currentTile.getNext() == null){
			return null;
		}
		else{
			return getTile(index + 1);
		}
	}

	public void addGameObject(GameObject gameObject) {
		TileNode startTile = searchTileByID(0, gameObject.getStartPoint());
		TileNode endTile = searchTileByID(0, gameObject.getEndPoint());

		if (startTile == null || endTile == null) {
			throw new IllegalArgumentException("Invalid start or end position");
		}

		if (gameObject instanceof Ladder) {
			startTile.setLadderDestination(endTile);
		} else {
			startTile.setSnakeDestination(endTile);
		}
	}

	public void movePlayer(Player player, int steps) {
		// Move the player forward by the given number  of steps
		int newTile = player.getPosition() + steps;

		if(newTile >= size) {
			player.setPosition(size);
		} else {

			TileNode current = searchTileByID(0, newTile);
			// Check for Snakes and Ladders and move the player accordingly
			TileNode snakeDest = current.getSnakeDestination();
			TileNode ladderDest = current.getLadderDestination();
			current.addPlayerToTile(player);
			player.setPosition(Objects.requireNonNullElseGet(snakeDest, () -> Objects.requireNonNullElse(ladderDest, current)).getTileNumber());
		}
	}

	//TODO refine this method
	private void deleteAll(TileNode node) {
		if (node == null) {
			return;
		}
		deleteAll((TileNode) node.getNext());
		node.setNext(null);
	}
}