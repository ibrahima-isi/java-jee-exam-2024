package gn.dev.examainjee2024.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {
    /**
     * Primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * Relation to immeuble
     */
    @OneToMany(mappedBy = "user")
    private List<Immeuble> immeubles;

    /**
     * Relation to Location
     */
    @OneToMany(mappedBy = "user")
    private List<Location> locations;

    /**
     * Relation to Payment
     */
    @OneToMany(mappedBy = "user")
    private List<Payment> payments;

}
