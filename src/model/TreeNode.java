package model;

public class TreeNode implements Comparable<TreeNode>{

    private TreeNode left;
    private TreeNode right;
    private int score;

    //playerSymbol is yet to be implemented
    public TreeNode(String name, int score) {
        this.score = score;
        left = null;
        right = null;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(TreeNode o) {
        return Integer.compare(this.getScore(), o.getScore());
    }
}

