package gn.dev.examainjee2024.entity;

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

}
