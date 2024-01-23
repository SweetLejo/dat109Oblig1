package org.example.db;


import org.example.snakesAndLadders.board.Square;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class BoardDAO {




    //do this in every method not the constructor
    public BoardDAO() {
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

   public void saveBatch(List<Square> squares){

       EntityManager entityManager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
       entityManager.getTransaction().begin();
       squares.forEach(i -> entityManager.persist(i));
       entityManager.getTransaction().commit();
       entityManager.close();
   }

}
