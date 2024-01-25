package org.example.snakesAndLadders.board;

import org.example.db.BoardService;
import org.example.snakesAndLadders.player.Player;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


public class Board {

    private List<Square> squares;
    private List<Player> players;


    public Board(List<Player> players) {


    }

    public Board() {

    }

    private void setWormHoles(){
        Random random = new Random();
        for(int i = 0 ; i < 15 ; i++) {
            Square start = squares.get(random.nextInt(1, 98));
            Square destination = squares.get(random.nextInt(1, 98));
            if(start.getWormhole() == null && destination.getWormhole() == null){
                start.setWormhole(destination);
            }else{
                i--;
            }
        }
    }

    public void round(){
        for(Player p : players){
            int move = p.getDie().roll() + p.getPosition().getValue();
            if(move < 100){
                Square newPos = squares.get(move).getWormhole() == null ? squares.get(move) : squares.get(move).getWormhole();
                p.setPosition(newPos);
            }

        }
    }

}
