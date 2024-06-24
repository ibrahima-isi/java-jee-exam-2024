package gn.dev.examainjee2024.dao;

import gn.dev.examainjee2024.dao.interfaces.IAppartment;
import gn.dev.examainjee2024.entity.Appartment;
import gn.dev.examainjee2024.entity.Immeuble;
import gn.dev.examainjee2024.entity.Location;

import javax.persistence.EntityManager;
import java.util.List;

public class AppartmentDAO implements IAppartment {
    private EntityManager entityManager;
    private List<Appartment> appartements;

    /**
     * @return
     */
    @Override
    public List<Appartment> getAppartments() {
        return List.of();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Appartment getAppartmentById(long id) {
        return null;
    }

    /**
     * @param appartment
     * @return
     */
    @Override
    public int addAppartment(Appartment appartment) {
        return 0;
    }

    /**
     * @param appartment
     * @return
     */
    @Override
    public int updateAppartment(Appartment appartment) {
        return 0;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public int deleteAppartment(long id) {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public Immeuble getAppartmentImmeuble() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Location> getAppartmentLocations() {
        return List.of();
    }
}
