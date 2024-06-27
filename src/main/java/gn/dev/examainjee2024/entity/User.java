package gn.dev.examainjee2024.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    /**
     * Primary key
     */
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userID;

    @Setter
    @Getter
    @Column(unique = true, length = 50)
    private String userName;
    @Setter
    @Getter
    @Column(unique = true, length = 50)
    private String userEmail;
    @Setter
    @Getter
    @Column(length = 30)
    private String userPassword;
    /**
     * the status of the entity, if defined to true then the entity will be listed, if not, he will be in archived
     */
    @Setter
    @Getter
    @Column(columnDefinition = "boolean default true")
    private boolean status;

    /**
     * the role of the user
     */
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "role_id", columnDefinition = "int default 2")
    private Role role;

    /**
     * Relation to immeuble, help get all immeubles as a list from the immeuble owner
     */
    @Setter
    @Getter
    @OneToMany(mappedBy = "user")
    private List<Immeuble> immeubles;

    /**
     * Relation to Location, help get all locations as a list from the location owner
     */
    @Setter
    @Getter
    @OneToMany(mappedBy = "user")
    private List<Location> locations;

    /**
     * Relation to Payment, help get all payments as a list from the payment owner
     */
    @Setter
    @Getter
    @OneToMany(mappedBy = "user")
    private List<Payment> payments;

    // constructor

    public User() {
    }

    // Getter and setter

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
