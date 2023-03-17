package model;

public class ScoreTree<T extends Node> {

	private TreeNode root;
	private final int MAX_SIZE = 3;
	private int currentSize ;

	public ScoreTree() {
		currentSize = 0;
		this.root = null;
	}

	public TreeNode getRoot() {
		return this.root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public void addNode(TreeNode node) throws NoMorePlayersException {
		if (root == null) {
			setRoot(node);
			currentSize++;
		} if(currentSize == MAX_SIZE){
			throw new NoMorePlayersException("No more players can be added");
		} else {
			addNode(root, node);
			currentSize++;
		}
	}

	private TreeNode addNode(TreeNode current, TreeNode node) {
		if (current == null) {
			return node;
		}
		if (node.compareTo(current) < 0) {
			current.setLeft(addNode((TreeNode) current.getLeft(), node));
		} else if (node.compareTo(current) > 0) {
			current.setRight(addNode((TreeNode) current.getRight(), node));
		} else {
			return current;
		}
		return current;
	}

	public String displayDescending() {
		StringBuilder sb = new StringBuilder();
		displayDescending(root, sb);
		return sb.toString();
	}

	private void displayDescending(TreeNode node, StringBuilder sb) {
		if (node == null) {
			return;
		}
		displayDescending((TreeNode) node.getRight(), sb);
		sb.append("Player ").append(node.getPlayerSymbol()).append(": ").append(node.getScore()).append("\n");
		displayDescending((TreeNode) node.getLeft(), sb);
	}


	public Node deleteAll() {
		throw new UnsupportedOperationException();
	}
}

