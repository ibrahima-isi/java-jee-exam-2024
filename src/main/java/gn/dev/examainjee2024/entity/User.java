package gn.dev.examainjee2024.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    /**
     * Primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userID;

    @Column(unique = true, length = 50)
    private String userName;
    @Column(unique = true, length = 50)
    private String userEmail;
    @Column(length = 30)
    private String userPassword;
    /**
     * the status of the entity, if defined to true then the entity will be listed, if not, he will be in archived
     */
    @Column(columnDefinition = "boolean default true")
    private boolean status;

    /**
     * Relation to immeuble, help get all immeubles as a list from the immeuble owner
     */
    @OneToMany(mappedBy = "user")
    private List<Immeuble> immeubles;

    /**
     * Relation to Location, help get all locations as a list from the location owner
     */
    @OneToMany(mappedBy = "user")
    private List<Location> locations;

    /**
     * Relation to Payment, help get all payments as a list from the payment owner
     */
    @OneToMany(mappedBy = "user")
    private List<Payment> payments;

    // constructor

    public User() {
    }

    public User(boolean status, String userEmail, long userID, String userName, String userPassword) {
        this.status = status;
        this.userEmail = userEmail;
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    // Getter and setter


    public List<Immeuble> getImmeubles() {
        return immeubles;
    }

    public void setImmeubles(List<Immeuble> immeubles) {
        this.immeubles = immeubles;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userEmail='" + userEmail + '\'' +
                ", status=" + status +
                ", userName='" + userName + '\'' +
                '}';
    }


}
