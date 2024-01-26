package org.example.db;


import org.example.snakesAndLadders.board.Board;
import org.example.snakesAndLadders.board.Square;
import org.example.snakesAndLadders.player.Player;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class BoardDAO {

    private Board board;


    //do this in every method not the constructor
    public BoardDAO() {
    }

    public BoardDAO(Board board){
        this.board = board;
    }


    //create a new entity manager here and close it after the thing
   public void writeSquare(Square square) {
       EntityManager entityManager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
       entityManager.getTransaction().begin();
       entityManager.persist(square);
       entityManager.getTransaction().commit();
       entityManager.close();
   }

   public void deleteSquare(Square square){
       EntityManager entityManager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
       entityManager.getTransaction().begin();
       entityManager.remove(square);
       entityManager.getTransaction().commit();
       entityManager.close();
   }

   public void saveBatch(){
       EntityManager entityManager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
       entityManager.getTransaction().begin();
       board.getSquares().forEach(entityManager::persist);
       entityManager.getTransaction().commit();
       entityManager.close();
   }

   public Board getBoard(){
        EntityManager entityManager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
        List<Square> squares = entityManager.createQuery("from Square" ).getResultList();
        List<Player> players = entityManager.createQuery("from Player").getResultList();

        Board board = new Board();
        board.setSquares(squares);
        board.setPlayers(players);

        return board;


   }

}
