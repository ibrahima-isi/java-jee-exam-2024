package gn.dev.examainjee2024.dao.interfaces;

import gn.dev.examainjee2024.entity.Apartment;
import gn.dev.examainjee2024.entity.Immeuble;
import gn.dev.examainjee2024.entity.Location;

import java.util.List;

public interface IApartment {
    public List<Apartment> getApartments();
    public Apartment getApartmentById(long id);
    public int addApartment(Apartment apartment);
    public int updateApartment(Apartment apartment);
    public int deleteApartment(long id);
    public Immeuble getApartmentImmeuble();
    public List<Location> getApartmentLocations();
}
