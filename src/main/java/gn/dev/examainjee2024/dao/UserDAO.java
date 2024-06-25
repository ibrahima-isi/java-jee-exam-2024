package gn.dev.examainjee2024.dao;

import gn.dev.examainjee2024.dao.interfaces.IUser;
import gn.dev.examainjee2024.entity.Immeuble;
import gn.dev.examainjee2024.entity.Location;
import gn.dev.examainjee2024.entity.Payment;
import gn.dev.examainjee2024.entity.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

public class UserDAO implements IUser {
    private final EntityManager entityManager = DBConnection.getEntityManager();
    private final Logger LOGGER = Logger.getLogger(ApartmentDAO.class.getName());


    /**
     * @return
     */
    @Override
    public List<User> getUsers() {

        return List.of();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User getUserById(long id) {
        return null;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        return 0;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        return 0;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public int deleteUser(long id) {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public List<Immeuble> getUserImmeubles() {
        return List.of();
    }

    /**
     * @return
     */
    @Override
    public List<Location> getUserLocations() {
        return List.of();
    }

    /**
     * @return
     */
    @Override
    public List<Payment> getUserPayments() {
        return List.of();
    }
}
