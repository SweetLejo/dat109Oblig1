package org.example.db;


import org.example.snakesAndLadders.board.Board;
import org.example.snakesAndLadders.board.Square;
import org.example.snakesAndLadders.player.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


/**
 * @Author Leo
 * persisting, merging, deleting entities from postgres db with jpa
 */
public class BoardDAO {


    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");

    private Board board;

    public BoardDAO() {
    }

    public BoardDAO(Board board) {
        this.board = board;
    }


    /**
     *
     * @param square square to be added to board
     */
    public void writeSquare(Square square) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(square);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }


    /**
     *
     * @param square to be deleted from board
     */

    public void deleteSquare(Square square){
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       try {
           entityManager.getTransaction().begin();
           entityManager.remove(square);
           entityManager.getTransaction().commit();
       }finally {
           entityManager.close();
       }
   }


    /**
     * save all squares from the board to the table
     */

    public void saveNewSquares(){
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       try {
           entityManager.getTransaction().begin();
           board.getSquares().forEach(entityManager::persist);
           entityManager.getTransaction().commit();
       }finally {
           entityManager.close();
       }
   }
   
   /**
    * Deletes all previous data from the database and saves new board.
    * Sets this dao's board to the new board.
    * @param board to save
    */
   public void saveNewBoard(Board board) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();

       try {
           // Begin a transaction
           entityManager.getTransaction().begin();

           // Delete all existing squares and players

           entityManager.createQuery("DELETE FROM Player").executeUpdate();
           entityManager.createQuery("DELETE FROM Square").executeUpdate();

           // Persist the new board
           board.getSquares().forEach(entityManager::persist);
           board.getPlayers().forEach(entityManager::persist);

           // Commit the transaction
           entityManager.getTransaction().commit();
       } finally {
           // Close EntityManager
           entityManager.close();
       }
       this.board = board;

   }
   
   /**
    * Updates the existing entities of the board in the database
    */
   public void saveExistingBoard() {
	   EntityManager entityManager = entityManagerFactory.createEntityManager();
	   try{
	       entityManager.getTransaction().begin();
           board.getSquares().forEach(entityManager::merge);
           board.getPlayers().forEach(entityManager::merge);
           entityManager.getTransaction().commit();
       } finally {
           entityManager.close();
       }
   }

    /**
     *
     * @return the board that is saved in the database
     */
   public Board getBoard(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            List<Square> squares = entityManager.createQuery("from Square" ).getResultList();
            List<Player> players = entityManager.createQuery("from Player").getResultList();

           	board = null;
            board = new Board();
            board.setSquares(squares);
            board.setPlayers(players);
            board.setCurrentPlayer(players.getFirst());
        } finally {
        	System.err.println("Rrror getting stored board");
           entityManager.close();
        }
        return board;
   }

    /**
     *
     * @param player player to be saved
     */
   public void savePlayer(Player player){
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       try {
           entityManager.getTransaction().begin();
           entityManager.merge(player);
           entityManager.getTransaction().commit();
       } finally {
           entityManager.close();
       }

   }

}
