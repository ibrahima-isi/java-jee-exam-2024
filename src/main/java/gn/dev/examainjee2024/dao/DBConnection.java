package gn.dev.examainjee2024.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Connection class to connect to database
 */
public class DBConnection {
    private  static EntityManagerFactory entityManagerFactory;

    private DBConnection(){}

    /**
     * Create entity manager factory and return an entity manager from it
     * @return entity manager
     */
    public static EntityManager getEntityManager() {
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("exam_jee");
        }
        return entityManagerFactory.createEntityManager();
    }
}
