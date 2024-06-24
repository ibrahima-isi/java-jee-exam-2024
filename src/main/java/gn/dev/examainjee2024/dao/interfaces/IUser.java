package gn.dev.examainjee2024.dao.interfaces;

import gn.dev.examainjee2024.entity.Location;
import gn.dev.examainjee2024.entity.Payment;
import gn.dev.examainjee2024.entity.User;
import gn.dev.examainjee2024.entity.Immeuble;

import java.util.List;

public interface IUser {
    public List<User> getUsers();
    public User getUserById(long id);
    public int addUser(User user);
    public int updateUser(User user);
    public int deleteUser(long id);
    public List<Immeuble> getUserImmeubles();
    public List<Location> getUserLocations();
    public List<Payment> getUserPayments();

}
