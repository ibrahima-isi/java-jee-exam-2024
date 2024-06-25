package gn.dev.examainjee2024.dao;

import gn.dev.examainjee2024.dao.interfaces.IApartment;
import gn.dev.examainjee2024.entity.Apartment;
import gn.dev.examainjee2024.entity.Immeuble;
import gn.dev.examainjee2024.entity.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Apartment DAO implementation class of IApartment
 * @author ibrabowe97
 */
public class ApartmentDAO implements IApartment {
    /**
     * Entity Manager instance of Apartment
     */
    private final EntityManager entityManager = DBConnection.getEntityManager();
    /**
     * List of apartments
     */
    private List<Apartment> apartments;
    /**
     * Apartment instance, help stock after using id to get apartment
     */
    private Apartment apartment;

    /**
     * A Logger to log errors and warnings
     */
    private Logger LOGGER = Logger.getLogger(ApartmentDAO.class.getName());


    /**
     * get all apartments from database
     * @return apartments as List
     * @author ibrabowe97
     */
    @Override
    public List<Apartment> getAppartments() {
        EntityTransaction transaction = null;
        apartments = new ArrayList<>();

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            apartments = entityManager.createQuery("from Apartment", Apartment.class).getResultList();
            transaction.commit();
        }catch (Exception e){
            if(transaction != null ){
                transaction.rollback();
            }
//            e.printStackTrace();
            LOGGER.severe("Error retrieving apartments from database : " + e.getMessage());
            System.out.println("Error message : " + e.getMessage());
        }
        return apartments;
    }

    /**
     * @param id get apartment by id
     * @return apartment or null
     * @author ibrabowe97
     */
    @Override
    public Apartment getAppartmentById(long id) {
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            apartment = entityManager.find(Apartment.class, id);
            if (apartment == null) {
                throw new EntityNotFoundException("Apartment with id " + id + " not found");
            }
            transaction.commit();
        }catch (Exception e){
            if(transaction != null ){
                transaction.rollback();
            }
//            e.printStackTrace();
            LOGGER.severe("Error retrieving apartment with id " + id + ": " + e.getMessage());
            System.out.println("Error message : " + e.getMessage());
        }
        return apartment;
    }

    /**
     * add new apartment to database
     * @param apartment the new apartment to add
     * @return 1 if apartment added, 0 if not
     * @author ibrabowe97
     */
    @Override
    public int addAppartment(Apartment apartment) {
        return 0;
    }

    /**
     * @param apartment the new apartment to update with new data
     * @return 1 if update success, 0 if not
     * @author ibrabowe97
     */
    @Override
    public int updateAppartment(Apartment apartment) {
        return 0;
    }

    /**
     * @param id the id of the apartment to delete
     * @return 1 if delete success, 0 if not
     * @author ibrabowe97
     */
    @Override
    public int deleteAppartment(long id) {
        return 0;
    }

    /**
     * Get the immeuble of the appartment
     * @return one immeuble instance
     * @author ibrabowe97
     */
    @Override
    public Immeuble getAppartmentImmeuble() {
        return null;
    }

    /**
     * Get all the locations of the appartment
     * @return list of locations
     * @author ibrabowe97
     */
    @Override
    public List<Location> getAppartmentLocations() {
        return List.of();
    }
}
