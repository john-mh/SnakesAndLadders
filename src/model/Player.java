package model;

public class Player {
	private int position;
	private final char symbol;

	public Player(int startingPosition, char symbol) {
		this.position = startingPosition;
		this.symbol = symbol;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public char getSymbol() {
		return symbol;
	}

	public void move(int steps) {
		position += steps;
	}
}



