package gn.dev.examainjee2024.dao;

import gn.dev.examainjee2024.entity.Role;
import lombok.Data;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.logging.Logger;

@Data
public class RoleDAO {
    private Role role = null;
    private List<Role> roles;
    EntityManager entityManager = DBConnection.getEntityManager();
    private Logger LOGGER = Logger.getLogger(RoleDAO.class.getName());

    // get role by id
    public Role getRoleById(int id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            role = entityManager.find(Role.class, id);
            entityTransaction.commit();
            if (role == null) {
                throw new EntityNotFoundException("Role with id " + id + " not found");
            }
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            LOGGER.severe("Failed to get the role : " + e);
        }
        return role;
    }

    // get all roles from the database
    public  List<Role> getRoles() {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            roles = entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
            if (roles == null) {
                throw new EntityNotFoundException("Roles not found");
            }
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            LOGGER.severe("Failed to get the roles : " + e);
        }
        return roles;
    }
}
