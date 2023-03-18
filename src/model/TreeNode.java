package model;

public class TreeNode extends Node implements Comparable<TreeNode>{

    private TreeNode left;
    private TreeNode right;
    private int score = 0;

    //playerSymbol is yet to be implemented
    public TreeNode(char playerSymbol) {

    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public Node getRight() {
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

