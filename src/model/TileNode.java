package model;

public class TileNode extends Node{

	private TileNode snakeDestination;
	private TileNode ladderDestination;
	private final int tileNumber;

	public TileNode(int tileNumber) {
		this.tileNumber = tileNumber;
		next = null;
		snakeDestination = null;
		ladderDestination = null;
	}

	public int getTileNumber() {
		return tileNumber;
	}

	public Player[] getPlayersInTile() {
		return super.getPlayers();
	}

	public void setPlayersInTile(Player player, int index) {
		super.addPlayers(player, index);
	}

	public TileNode getSnakeDestination() {
		return snakeDestination;
	}

	public void setSnakeDestination(TileNode destination) {
		this.snakeDestination = destination;
	}

	public TileNode getLadderDestination() {
		return ladderDestination;
	}

	public void setLadderDestination(TileNode destination) {
		this.ladderDestination = destination;
	}

	public boolean hasPlayer(int index) {
		return super.getPlayers()[index] != null;
	}

	public boolean hasPlayers() {
		return super.getPlayers()[0] != null || super.getPlayers()[1] != null || super.getPlayers()[2] != null;
	}
}

