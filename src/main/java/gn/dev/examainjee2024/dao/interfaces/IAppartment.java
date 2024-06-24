package gn.dev.examainjee2024.dao.interfaces;

import gn.dev.examainjee2024.entity.Appartment;
import gn.dev.examainjee2024.entity.Immeuble;
import gn.dev.examainjee2024.entity.Location;

import java.util.List;

public interface IAppartment {
    public List<Appartment> getAppartments();
    public Appartment getAppartmentById(long id);
    public int addAppartment(Appartment appartment);
    public int updateAppartment(Appartment appartment);
    public int deleteAppartment(long id);
    public Immeuble getAppartmentImmeuble();
    public List<Location> getAppartmentLocations();
}
