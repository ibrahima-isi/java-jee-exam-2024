package gn.dev.examainjee2024.dao;

import gn.dev.examainjee2024.entity.Role;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@WebListener
public class RoleInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        addRoleIfNotExists("ADMIN");
        addRoleIfNotExists("USER");
        addRoleIfNotExists("TENANT");
        addRoleIfNotExists("OWNER");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    private void addRoleIfNotExists(String roleName) {
        EntityManager em = DBConnection.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            long count = (long) em.createQuery("SELECT COUNT(r) FROM Role r WHERE r.name = :roleName")
                    .setParameter("roleName", roleName)
                    .getSingleResult();

            if (count == 0) {
                Role role = new Role();
                role.setName(roleName);

                transaction.begin();
                em.persist(role);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

