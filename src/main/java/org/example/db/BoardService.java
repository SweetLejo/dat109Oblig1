package org.example.db;


import org.example.snakesAndLadders.board.Board;
import org.example.snakesAndLadders.board.Square;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired BoardRepo boardRepo;

    public Square saveBoard(Square square){
        return boardRepo.save(square);
    }
}
