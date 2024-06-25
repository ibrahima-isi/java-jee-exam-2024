package gn.dev.examainjee2024.dao.interfaces;

import gn.dev.examainjee2024.entity.Apartment;
import gn.dev.examainjee2024.entity.Immeuble;
import gn.dev.examainjee2024.entity.Location;

import java.util.List;

public interface IApartment {
    public List<Apartment> getAppartments();
    public Apartment getAppartmentById(long id);
    public int addAppartment(Apartment apartment);
    public int updateAppartment(Apartment apartment);
    public int deleteAppartment(long id);
    public Immeuble getAppartmentImmeuble();
    public List<Location> getAppartmentLocations();
}
