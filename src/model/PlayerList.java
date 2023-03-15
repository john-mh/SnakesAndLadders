package model;

public class PlayerList<T extends Node> {

	private Node head;
	private Node tail;

	public Node getHead() {
		return this.head;
	}

	public void setHead(Node node) {
		head = node;
	}

	public void addPlayer() {
		throw new UnsupportedOperationException();
	}

	public String getPlayerID() {
		throw new UnsupportedOperationException();
	}

	public Node deleteAll() {
		throw new UnsupportedOperationException();
	}

	public Node getTail() {
		return this.tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}
}

