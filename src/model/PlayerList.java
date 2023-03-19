package model;

public class PlayerList<T extends Node> {

	private PlayerNode head;
	private PlayerNode tail;
	private PlayerNode currentPlayer;

	public PlayerNode getHead() {
		return head;
	}

	public void setHead(PlayerNode node) {
		head = node;
	}

	public PlayerNode getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(PlayerNode node) {
		currentPlayer = node;
	}

	public void addPlayerNode(char symbol) {
		PlayerNode node = new PlayerNode();
		node.setPlayer(symbol);
		if (head == null) {
			head = node;
		} else {
			tail.setNext(node);
			node.setPrev(tail);
		}
		tail = node;
		tail.setNext(head);
	}

	public PlayerNode deleteAll() {
		throw new UnsupportedOperationException();
	}


}

