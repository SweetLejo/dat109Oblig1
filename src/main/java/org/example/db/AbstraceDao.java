package org.example.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author leo
 * @param <T> Base entity
 */
public abstract class AbstraceDao<T> {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");

    /**
     * Writes an entity to the database.
     *
     * @param entity Entity to be written.
     */
    public void writeEntity(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Deletes an entity from the database.
     *
     * @param entity Entity to be deleted.
     */
    public void deleteEntity(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Saves a list of entities to the database.
     *
     * @param entities List of entities to be saved.
     */
    public void saveEntities(Iterable<T> entities) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entities.forEach(entityManager::persist);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Deletes all entities of the given type from the database.
     */
    public void deleteAllEntities(Class<T> entityClass) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM " + entityClass.getSimpleName()).executeUpdate();
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Merges a list of entities into the database.
     *
     * @param entities List of entities to be merged.
     */
    public void mergeEntities(Iterable<T> entities) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entities.forEach(entityManager::merge);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Reads all entities of the given type from the database.
     *
     * @param entityClass Class of the entity.
     * @return List of entities.
     */
    public abstract Iterable<T> readAllEntities(Class<T> entityClass);
}



