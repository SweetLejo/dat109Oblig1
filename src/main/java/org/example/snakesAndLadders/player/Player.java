package org.example.snakesAndLadders.player;

import org.example.snakesAndLadders.board.Square;

import javax.persistence.*;

import java.awt.Color;
import java.util.Objects;
import java.util.Random;


/**
 * pretty standard entity class
 * @author leo
 */
@Entity
@Table(name = "player", schema = "dat109_oblig1")
public class Player {

    @Id
    @Column(name = "first_name")
    private String name;

    @Column(name = "piece")
    private Piece piece;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "square", name = "place")
    private Square position;

    public Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }

    public Player() {

    }

    public Square getPosition() {
        return position;
    }


    /**
     *
     * @param position new position of player
     */
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

    public int roll(){
        Random die = new Random();
        return die.nextInt(1, 7);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return player.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", piece=" + piece +
                ", position=" + position +
                '}';
    }
}
