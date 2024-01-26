package org.example.snakesAndLadders.board;

import org.example.snakesAndLadders.player.Player;

import javax.persistence.*;

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
    public String toString() {
        return "Square{" +
                "value=" + value +
                ", wormhole=" + wormhole +
                '}';
    }
}
