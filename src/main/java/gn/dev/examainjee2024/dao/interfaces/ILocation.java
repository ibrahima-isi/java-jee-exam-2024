package gn.dev.examainjee2024.dao.interfaces;

import gn.dev.examainjee2024.entity.*;

import java.util.List;

public interface ILocation {
    public List<Location> getLocations();
    public Location getLocationById(long id);
    public int addLocation(Location location);
    public int updateLocation(Location location);
    public int deleteLocation(long id);
    public User getLocationTenant();
    public Apartment getLocationAppartment();
    public List<Payment> getLocationPayments();
}
