package org.example.snakesAndLadders.board;

import org.example.snakesAndLadders.player.Player;

import javax.persistence.*;


/**
 * Entity class, each row = square in board table
 * @Author Leo
 */
@Entity
@Table(schema = "dat109_oblig1", name = "board")
public class Square {


    @Id
    @Column(name = "square")
    private int value;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "square", name = "wormhole", nullable = true)
    private Square wormhole;

    public Square(int value){
        this.value = value;
    }

    public Square() {

    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Square getWormhole() {
        return wormhole;
    }

    public void setWormhole(Square wormhole) {
        this.wormhole = wormhole;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return value == square.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return "Square{" +
                "value=" + value +
                ", wormhole=" + wormhole +
                '}';
    }
}
