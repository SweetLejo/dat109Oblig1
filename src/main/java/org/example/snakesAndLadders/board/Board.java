package org.example.snakesAndLadders.board;

import org.example.snakesAndLadders.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @Author Leo
 */
public class Board {

    private List<Square> squares;
    private List<Player> players;

    private Player currentPlayer;


    /**
     *
     * @param squares the 100 squares in a list that already have snakes and ladders
     * @param players the players currently playing
     */
    public Board(List<Square> squares, List<Player> players) {
    	this.squares = squares;
    	this.players = players;
    }

    public Board() {

    }


    /**
     * createNewBoardFactory statically return a board
     * @param amountOfPlayers number of players to be allocated to the fielt
     * @return board with players and
     */
    public static Board createNewBoard(int amountOfPlayers) {
    	// TODO
        Board board = new Board();
        board.setSquares(
                IntStream.rangeClosed(0, 100).mapToObj(Square::new).toList()
        );
        board.setWormHoles();
        board.setPlayers(Arrays.asList(new Player[amountOfPlayers]));
    	return board;
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


    /**
     * moves current player after die roll, and updates current player to next one in player array
     */
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
