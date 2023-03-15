
package model;

public class GameObject {
	private int startPoint;
	private int endPoint;
	private String id;

	public GameObject(String aId) {
		this.id = aId;
	}

	public int getStartPoint() {
		return this.startPoint;
	}

	public void setStartPoint(int aStartPoint) {
		this.startPoint = aStartPoint;
	}

	public int getEndPoint() {
		return this.endPoint;
	}

	public void setEndPoint(int aEndPoint) {
		this.endPoint = aEndPoint;
	}

	public void getAttribute() {
		throw new UnsupportedOperationException();
	}

	public void setAttribute(Object aAttribute) {
		throw new UnsupportedOperationException();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String aId) {
		this.id = aId;
	}
}

