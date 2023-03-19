package model;

public class PlayerNode extends Node{

    private PlayerNode previous;

    public PlayerNode getPrev() {
        return previous;
    }

    public void setPrev(PlayerNode node) {
        this.previous = node;
    }
}


