package org.example.db;


import org.example.snakesAndLadders.board.Square;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class BoardDAO {
    private EntityManager entityManager;


    public BoardDAO() {
        entityManager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
    }

   public void writeSquare(Square square) {
       entityManager.getTransaction().begin();
       entityManager.persist(square);
       entityManager.getTransaction().commit();
       entityManager.close();
   }

   public void deleteSquare(Square square){
       entityManager.getTransaction().begin();
       entityManager.remove(square);
       entityManager.getTransaction().commit();
       entityManager.close();
   }

}
