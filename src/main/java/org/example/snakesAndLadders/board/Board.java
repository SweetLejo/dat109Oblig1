package org.example.snakesAndLadders.board;

import org.example.snakesAndLadders.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Leo
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
        this.currentPlayer = players.get(0);
        players.forEach(p -> p.setPosition(squares.get(0)));
    }

    public Board() {

    }

    /**
     * createNewBoardFactory statically return a board
     * @param players who will be playing
     * @return board with players and
     */
    public static Board createNewBoard(List<Player> players) {
    	// TODO
        Board board = new Board();
        board.setSquares(
                IntStream.rangeClosed(0, 99).mapToObj(Square::new).toList()
        );
        board.setWormHoles();
        board.setPlayers(players);
        board.setCurrentPlayer(board.getPlayers().get(0));
        board.players.forEach(p -> p.setPosition(board.squares.get(0)));
    	return board;
    }

    /**
     * set the ladders and snakes randomly
     */
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
     * @return the die roll result
     */
    public int round(){
    	int dieRoll = currentPlayer.roll();
        int move = dieRoll + currentPlayer.getPosition().getValue();

        moveToPosAndChangePlayer(move);
        
        return dieRoll;
    }

    /**
     * move without randomized new position
     * @param number
     */
    public void roundRiggedDie(int number){
        int move = currentPlayer.getPosition().getValue() + number;
        moveToPosAndChangePlayer(move);
    }

    /**
     * change current player to next in list and
     * @param move new position for current player
     */
    private void moveToPosAndChangePlayer(int move){
        if(move < 100){
            Square newPos = squares.get(move).getWormhole() == null ? squares.get(move) : squares.get(move).getWormhole();
            currentPlayer.setPosition(newPos);
        }
        changeCurrent();
    }

    private void changeCurrent(){
        boolean changed = false;
        for(int i = 0; i < players.size() && !changed; i++){
            if(currentPlayer.equals(players.get(i))){
                currentPlayer = players.get((i + 1) % players.size());
                changed = true;
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

    /**
     * changes who the current player is (will affect the round() method)
     * @param currentPlayer the new currentPlayer
     */
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
