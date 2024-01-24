package org.example;

import org.example.db.BoardDAO;
import org.example.db.PlayerDAO;
import org.example.snakesAndLadders.board.Board;
import org.example.snakesAndLadders.player.Piece;
import org.example.snakesAndLadders.player.Player;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player("john", Piece.BLUE);
        Player p2 = new Player("Severin", Piece.PURPLE);
        Player p3 = new Player("Aleks", Piece.YELLOW);
        Player p4 = new Player("Dag", Piece.GREEN);

        List<Player> players = Arrays.asList(p1, p2, p3, p4);
        Board board = new Board(players);

        for(int i = 0; i < 10; i++) {
            board.round();
            System.out.println(p1.getPosition().getValue());
        }




    }
}