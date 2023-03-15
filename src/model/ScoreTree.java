package model;

public class ScoreTree<T extends Node> {

	private TreeNode root;

	public ScoreTree() {
		this.root = null;
	}

	public TreeNode getRoot() {
		return this.root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
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

