package org.example.db;

import org.example.snakesAndLadders.player.Player;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PlayerDAO {

    private Player player;
    public PlayerDAO(Player player) {
        this.player = player;
    }

    public void addPlayer(){
        EntityManager entityManager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(player);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
