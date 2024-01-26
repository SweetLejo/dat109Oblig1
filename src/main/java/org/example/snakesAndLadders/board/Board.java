package org.example.snakesAndLadders.board;

import org.example.snakesAndLadders.player.Player;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


public class Board {

    private List<Square> squares;
    private List<Player> players;


    public Board(List<Player> players) {
        this.players = players;
        squares = IntStream.rangeClosed(1, 100).mapToObj(Square::new).toList();

        setWormHoles();

        players.forEach(p -> p.setPosition(squares.getFirst()));

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
            int move = p.roll() + p.getPosition().getValue();
            if(move < 100){
                Square newPos = squares.get(move).getWormhole() == null ? squares.get(move) : squares.get(move).getWormhole();
                p.setPosition(newPos);
            }

        }
    }

    public List<Square> getSquares() {
        return squares;
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
