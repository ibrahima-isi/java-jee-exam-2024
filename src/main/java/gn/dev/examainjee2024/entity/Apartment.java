package gn.dev.examainjee2024.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "apartments")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apartment_id")
    private long apartmentID;
    @Column(length = 5)
    private String apartmentNumber;
    @Column(length = 10)
    private String numberOfRoom;
    /**
     * The area of the apartments, integer
     */
    @Column
    private double surfaceArea;
    /**
     * the status of the entity, if defined to true then the entity will be listed, if not, he will be in archived
     */
    @Column(columnDefinition = "boolean default true")
    private boolean status;

    /**
     * This is the relation between the apartment and the immeuble, immeuble is so a foreign key
     */
    @ManyToOne
    @JoinColumn(name = "immeuble_id")
    private Immeuble immeuble;

    /**
     * This is the relation between the apartment and the location, location is so a foreign key
     */
    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL)
    private List<Location> locations;

    public Apartment() {
    }

    public Apartment(long apartmentID, Immeuble immeuble, String apartmentNumber, String numberOfRoom, boolean status, double surfaceArea) {
        this.apartmentID = apartmentID;
        this.immeuble = immeuble;
        this.apartmentNumber = apartmentNumber;
        this.numberOfRoom = numberOfRoom;
        this.status = status;
        this.surfaceArea = surfaceArea;
    }

    public long getApartmentID() {
        return apartmentID;
    }

    public void setApartmentID(long apartmentID) {
        this.apartmentID = apartmentID;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Immeuble getImmeuble() {
        return immeuble;
    }

    public void setImmeuble(Immeuble immeuble) {
        this.immeuble = immeuble;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public String getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(String numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentID=" + apartmentID +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", numberOfRoom='" + numberOfRoom + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", status=" + status +
                '}';
    }

}
