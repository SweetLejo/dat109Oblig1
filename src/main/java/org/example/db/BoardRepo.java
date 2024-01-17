package org.example.db;

import org.example.snakesAndLadders.board.Board;
import org.example.snakesAndLadders.board.Square;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepo extends JpaRepository<Square, Integer> {

}
