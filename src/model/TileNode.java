package model;

public class TileNode extends Node{

	private TileNode destination;
	private GameObject gameObject;
	private final int tileNumber;

	public TileNode(int tileNumber) {
		this.tileNumber = tileNumber;
		next = null;
		destination = null;
	}

	public int getTileNumber() {
		return tileNumber;
	}

	public Player[] getPlayersInTile() {
		return super.getPlayers();
	}

	/*
	public void setPlayersInTile(Player player, int index) {
		super.addPlayers(player, index);
	}
	 */

	public TileNode getDestination() {
		return destination;
	}

	public void setDestination(TileNode destination) {
		this.destination = destination;
	}

	public GameObject getGameObject() {
		return gameObject;
	}

	public void setGameObject(GameObject gameObject) {
		this.gameObject = gameObject;
	}

	public boolean hasPlayer(int index) {
		return super.getPlayers()[index] != null;
	}

	public boolean hasPlayers() {
		return super.getPlayers()[0] != null || super.getPlayers()[1] != null || super.getPlayers()[2] != null;
	}
}

