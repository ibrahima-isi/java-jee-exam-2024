package gn.dev.examainjee2024.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "immeubles")
public class Immeuble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "immeuble_id")
    private long immeubleID;
    @Column(unique = true, length = 50)
    private String immeubleName;
    @Column(length = 50)
    private String immeubleAddress;
    @Column(length = 150)
    private String description;

    /**
     * the status of the entity, if defined to true then the entity will be listed, if not, he will be in archived
     */
    @Column(columnDefinition = "boolean default true")
    private boolean status;

    /**
     * Relation to the owner of the Immeuble
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Relation to the apartments of the immeuble, delete apartment if immeuble deleted is activated.
     */
    @OneToMany(mappedBy = "immeuble", cascade = CascadeType.ALL)
    private List<Apartment> apartments;

    public Immeuble() {
    }

    public Immeuble(String description, String immeubleAddress, long immeubleID, String immeubleName, boolean status, User user, List<Apartment> apartments) {
        this.description = description;
        this.immeubleAddress = immeubleAddress;
        this.immeubleID = immeubleID;
        this.immeubleName = immeubleName;
        this.status = status;
        this.user = user;
        this.apartments = apartments;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImmeubleAddress() {
        return immeubleAddress;
    }

    public void setImmeubleAddress(String immeubleAddress) {
        this.immeubleAddress = immeubleAddress;
    }

    public long getImmeubleID() {
        return immeubleID;
    }

    public void setImmeubleID(long immeubleID) {
        this.immeubleID = immeubleID;
    }

    public String getImmeubleName() {
        return immeubleName;
    }

    public void setImmeubleName(String immeubleName) {
        this.immeubleName = immeubleName;
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
        return "Immeuble{" +
                "immeubleID=" + immeubleID +
                ", immeubleName='" + immeubleName + '\'' +
                ", immeubleAddress='" + immeubleAddress + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
