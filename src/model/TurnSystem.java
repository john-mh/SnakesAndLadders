package model;

public class TurnSystem {

	private PlayerList<PlayerNode> players;

	public TurnSystem() {
		players = new PlayerList<PlayerNode>();
	}

	public void addPlayer(char symbol) {
		if(players.getHead() == null){
			players.addPlayerNode(symbol);
			players.setCurrentPlayer(players.getHead());
		}
		else
			players.addPlayerNode(symbol);
	}

	public char getCurrentPlayerSymbol() {
		return players.getCurrentPlayer().getPlayerSymbol();
	}

	public void nextTurn() {
		players.setCurrentPlayer((PlayerNode) players.getCurrentPlayer().getNext());
	}


	public void deleteAll() {
		throw new UnsupportedOperationException();
	}

	public Player getCurrentPlayer() {
		return players.getCurrentPlayer().getPlayer();
	}
}

