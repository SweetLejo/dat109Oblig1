package org.example.snakesAndLadders.player;

import org.example.snakesAndLadders.board.Square;



public class Player {

    private String name;
    private Piece piece;

    private Die die;

    private Square position;


    public Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
        this.die = new Die();
    }

    public Square getPosition() {
        return position;
    }

    public void setPosition(Square position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Die getDie() {
        return die;
    }

    public void setDie(Die die) {
        this.die = die;
    }

}
