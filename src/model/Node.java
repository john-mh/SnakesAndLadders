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

	public int getPlayerPosition(Player player){
		return player.getPosition();
	}

	public void setPlayer(char symbol) {
		this.player = new Player(symbol);
	}

	public char getPlayerSymbol() {
		return player.getSymbol();
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

	protected Player getPlayer(int index){
		return players[index];
	}

	public void addPlayerToTile(Player player){
		players[getNullIndex()] = player;
	}

}

