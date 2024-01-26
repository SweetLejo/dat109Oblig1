package org.example.snakesAndLadders.board;

import org.example.snakesAndLadders.player.Player;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Board {

    private List<Square> squares;
    private List<Player> players;

    private Player currentPlayer;



    public Board(List<Square> squares, List<Player> players) {
    	this.squares = squares;
    	this.players = players;
    	setWormHoles();
    }

    public Board() {

    }
    
    public static Board createNewBoard(int amountOfPlayers) {
    	// TODO
    	return null;
    }
/*
    public Board(List<Square> squares){
        this.squares = squares;
    }*/

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
        int move = currentPlayer.roll() + currentPlayer.getPosition().getValue();

        if(move < 100){
            Square newPos = squares.get(move).getWormhole() == null ? squares.get(move) : squares.get(move).getWormhole();
            currentPlayer.setPosition(newPos);
        }
        
        for(int i = 0; i < players.size(); i++){
            if(currentPlayer.equals(players.get(i))){
                currentPlayer = players.get((i + 1) % players.size());
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

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    
    @Override
    public String toString() {
        return "Board{" +
                "squares=" + squares +
                ", players=" + players +
                '}';
    }
    
}
