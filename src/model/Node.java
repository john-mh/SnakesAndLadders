package model;

public abstract class Node {

    protected Node next;
    private Player player;
	private final Player[] players = new Player[3];

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

	public String addPlayer(Player player){
		if(this.player != null)
			return "Player already exists";
		else {
			this.player = player;
			return "Player added";
		}
	}

	public int getNullIndex(){
		return getNullIndex(0);
	}

	private int getNullIndex(int pointer){
		if (players[pointer] == null)
			return pointer;
		if(players[pointer] != null && pointer == players.length - 1)
			return -1;
		else return getNullIndex(pointer + 1);
	}

	protected Player[] getPlayers() {
		return players;
	}

	public String addPlayerToTile(Player player){
		if (getNullIndex() == -1){
			return "No more space for players";
		}
		else {
			players[getNullIndex()] = player;
			return "Player"+player.getSymbol()+" added";
		}

	}



}

