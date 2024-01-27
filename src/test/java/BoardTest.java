import org.example.db.BoardDAO;
import org.example.snakesAndLadders.board.Board;
import org.example.snakesAndLadders.board.Square;
import org.example.snakesAndLadders.player.Piece;
import org.example.snakesAndLadders.player.Player;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BoardTest {

    private Board board;
    @BeforeAll
    void setup(){
        List<Square> squares = IntStream.rangeClosed(0, 100).mapToObj(Square::new).toList();
        squares.get(10).setWormhole(squares.get(20));
        squares.get(30).setWormhole(squares.get(40));
        squares.get(80).setWormhole(squares.get(70));
        squares.get(60).setWormhole(squares.get(50));

        List<Player> players = Arrays.asList(new Player("hello", Piece.BLUE),
        new Player("world", Piece.PINK),
        new Player("idk", Piece.YELLOW),
        new Player("severin", Piece.GREEN));
        board = new Board(squares, players);
    }

    @Test
    void testMove(){
        Player current = board.getCurrentPlayer();
        int currentPos = current.getPosition().getValue();
        board.roundRiggedDie(5);
        assertNotEquals(current, board.getCurrentPlayer());
        assertEquals(currentPos + 5, current.getPosition().getValue());

    }

    @Test
    void testSaveAndLoad(){
        BoardDAO boardDAO = new BoardDAO(board);
        boardDAO.saveNewBoard(board);
        Board answerBoard = boardDAO.getBoard();
        assertEquals(board.getPlayers().size(), answerBoard.getPlayers().size());
        assertEquals(board.getSquares().size(), answerBoard.getSquares().size());
    }


    @Test
    void testMerge(){

    }

    @Test
    void loadFromDB(){

    }

    @Test
    void testFactory(){
        Board testBoard = Board.createNewBoard(Arrays.asList(new Player("john doe", Piece.PINK), new Player("Joseph", Piece.BLUE)));
        assertEquals(100, testBoard.getSquares().size());
        assertEquals(2, testBoard.getPlayers().size());
    }

    @Test
    void testLadder(){
        Player current = board.getCurrentPlayer();
        int oldPos = current.getPosition().getValue();
        board.roundRiggedDie(30 - oldPos);

        assertEquals(current.getPosition(), board.getSquares().get(40));
    }

    @Test
    void testSnake(){
        Player current = board.getCurrentPlayer();
        int oldPos = current.getPosition().getValue();
        board.roundRiggedDie(80 - oldPos);

        assertEquals(current.getPosition(), board.getSquares().get(70));

    }

}
