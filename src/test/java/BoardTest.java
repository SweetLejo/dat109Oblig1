import org.example.snakesAndLadders.board.Board;
import org.example.snakesAndLadders.board.Square;
import org.example.snakesAndLadders.player.Piece;
import org.example.snakesAndLadders.player.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


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

    }

    @Test
    void testSave(){}

    @Test
    void testLoad(){}

    @Test
    void testConstructor(){}

    @Test
    void testWhatever(){}

}
