package org.example.snakesAndLadders.player;

import org.example.snakesAndLadders.board.Square;

import javax.persistence.*;


@Entity
@Table(name = "player", schema = "dat109_oblig1")
public class Player {

    @Id
    @Column(name = "first_name")
    private String name;
    private Piece piece;


    @OneToOne
    @JoinColumn(referencedColumnName = "square", name = "place")
    private Square position;

    @Transient
    private Die die = new Die();

    public Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }

    public Player() {

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
