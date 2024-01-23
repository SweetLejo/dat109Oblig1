package org.example.db;

import org.example.snakesAndLadders.player.Player;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PlayerDAO {
    private EntityManager entityManager;


    public PlayerDAO() {
        entityManager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
    }

    public void addPlayer(Player player){

    }


}
