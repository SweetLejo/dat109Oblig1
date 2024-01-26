package org.example.db;

import org.example.snakesAndLadders.player.Player;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class PlayerDAO {

    private List<Player> players;
    public PlayerDAO(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player){
        EntityManager entityManager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(player);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removePlayer(Player player){
        EntityManager entityManager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(player);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void addPlayers(){

        EntityManager entityManager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
        entityManager.getTransaction().begin();
        players.forEach(entityManager::persist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
