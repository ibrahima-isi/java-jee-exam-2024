package gn.dev.examainjee2024.dao.interfaces;

import gn.dev.examainjee2024.entity.User;

import java.util.List;

public interface IUser {
    public List<User> getUsers();
    public User getUserById(long id);
    public long addUser(User user);
    public long updateUser(User user);
    public long deleteUser(long id);
//    public List<Immeuble> getUserImmeubles();
//    public List<Location> getUserLocations();
//    public List<Payment> getUserPayments();

}
