package model;

public abstract class Node {

    protected Node next;
    private Player player;
	private Player[] players = new Player[3];

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public char getPlayerSymbol() {
		return player.getSymbol();
	}

	public void addPlayers(Player player, int index) {
		players[index] = player;
	}

	protected Player[] getPlayers() {
		return players;
	}



}

