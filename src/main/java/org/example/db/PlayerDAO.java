package org.example.db;

import org.example.snakesAndLadders.player.Player;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PlayerDAO {

    public PlayerDAO() {

    }

    public void addPlayer(Player player){
        EntityManager entityManager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(player);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
