package gn.dev.examainjee2024.entity;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private long locationID;
    /**
     * the status of the entity, if defined to true then the entity will be listed, if not, he will be in archived
     */
    @Column(columnDefinition = "boolean default true")
    private boolean status;

    /**
     * Relation to the tenant of the location
     */
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private User user;

    /**
     * Relation to the apartment of the location
     */
    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    /**
     * The timestamp is on LocalTime so that we can have the hour if needed
     */
    @Column
    private LocalDate locationDate;

    public Location() {
    }

    public Location(Apartment apartment, LocalDate locationDate, long locationID, boolean status, User user) {
        this.apartment = apartment;
        this.locationDate = locationDate;
        this.locationID = locationID;
        this.status = status;
        this.user = user;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public LocalDate getLocationDate() {
        return locationDate;
    }

    public void setLocationDate(LocalDate locationDate) {
        this.locationDate = locationDate;
    }

    public long getLocationID() {
        return locationID;
    }

    public void setLocationID(long locationID) {
        this.locationID = locationID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Location{" +
                ", locationID=" + locationID +
                "apartment=" + apartment +
                ", status=" + status +
                ", user=" + user +
                ", locationDate=" + locationDate +
                '}';
    }
}
