package gn.dev.examainjee2024.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnection {
    private  static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManagerFactory() {
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("exam_jee");
        }
        return entityManagerFactory.createEntityManager();
    }
}
