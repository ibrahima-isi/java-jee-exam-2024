package gn.dev.examainjee2024.dao;

import gn.dev.examainjee2024.dao.interfaces.IAppartment;
import gn.dev.examainjee2024.entity.Appartment;
import gn.dev.examainjee2024.entity.Immeuble;
import gn.dev.examainjee2024.entity.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Appartment DAO implementation class of IAppartment
 * @author ibrab
 */
public class AppartmentDAO implements IAppartment {
    /**
     * Entity Manager instance of Appartment
     */
    private final EntityManager entityManager = DBConnection.getEntityManager();
    /**
     * List of appartements
     */
    private List<Appartment> appartements;
    /**
     * Appartment instance, help stock after using id to get appartment
     */
    private Appartment appartment;


    /**
     * get all appartements from database
     * @return appartements as List
     */
    @Override
    public List<Appartment> getAppartments() {
        EntityTransaction transaction = entityManager.getTransaction();
        appartements = new ArrayList<>();
        try{
            transaction.begin();
            appartements = entityManager.createQuery("from Appartment", Appartment.class).getResultList();
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return appartements;
    }

    /**
     * @param id get appartment by id
     * @return appartment or null
     */
    @Override
    public Appartment getAppartmentById(long id) {
        return null;
    }

    /**
     * add new appartment to database
     * @param appartment the new appartment to add
     * @return true if appartment added, false if not
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
