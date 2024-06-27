package gn.dev.examainjee2024.dao;

import gn.dev.examainjee2024.dao.interfaces.IUser;
import gn.dev.examainjee2024.entity.User;
import gn.dev.examainjee2024.webServlet.models.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.io.File;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class UserDAO implements IUser {
    private final EntityManager entityManager = DBConnection.getEntityManager();
    private final Logger LOGGER = Logger.getLogger(ApartmentDAO.class.getName());


    /**
     * @return a list of User
     */
    @Override
    public List<User> getUsers() {
        EntityTransaction entityTransaction = null;
        UserModel userModel = new UserModel();

        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            userModel.setUsers(entityManager.createQuery("FROM User", User.class).getResultList());
            entityTransaction.commit();
        }
        catch (PersistenceException exception){
            if(entityTransaction != null){
                entityTransaction.rollback();
            }
            LOGGER.severe("Error Persistence: " + exception);
        }
        return userModel.getUsers();
    }

    /**
     * @param id the id of the user to get
     * @return a User instance or null | Throw an EntityNotFoundException
     */
    @Override
    public User getUserById(long id) {
        EntityTransaction entityTransaction = null;
        User user = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            user = entityManager.find(User.class, id);
            entityTransaction.commit();
            if (user == null) {
                throw new EntityNotFoundException("User with id " + id + " not found");
            }
        }
        catch (Exception e){
            if(entityTransaction != null){
                entityTransaction.rollback();
            }
            LOGGER.severe("Failed to get the user : " + e);
        }
        return user;
    }

    /**
     * @param user the user to add
     * @return the user id if added, 0 if not
     */
    @Override
    public long addUser(User user) {
        EntityTransaction entityTransaction = null;
        try {
            // Assurez-vous que le répertoire existe
            File logDir = new File("/logs/user");
            if (!logDir.exists()) {
                logDir.mkdirs(); // Créez les répertoires manquants
            }
            Handler fileHandler = new FileHandler("/logs/user/userLogs.log");
            LOGGER.addHandler(fileHandler);
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(user);
            entityTransaction.commit();
            return user.getUserID();
        }
        catch (Exception e){
            if (entityTransaction != null){
                entityTransaction.rollback();
            }
            LOGGER.severe("Failed to add user : " + e );
        }
        return 0;
    }

    /**
     * @param user the user to update
     * @return the user id if updated, 0 if not
     */
    @Override
    public long updateUser(User user) {
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(user);
            entityTransaction.commit();
            return user.getUserID();
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            LOGGER.severe("Failed to update user: " + e);
        }

        return 0;
    }

    /**
     * @param id the id of the user to delete
     * @return the user id if deleted, 0 if not
     */
    @Override
    public long deleteUser(long id) {
        EntityTransaction entityTransaction = null;
        try{
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            User user = entityManager.find(User.class, id);
            if (user != null){
                entityManager.remove(user);
                entityTransaction.commit();
                return user.getUserID();
            }
        }
        catch (Exception e){
            if (entityTransaction != null) entityTransaction.rollback();
            LOGGER.severe("Failed to delete user with id : " + id + ", Reason: " +e);
        }
        return 0;
    }

}
