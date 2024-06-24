package gn.dev.examainjee2024.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Immeuble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long immeubleID;
    @Column(unique = true, length = 30)
    private String immeubleName;
    @Column(length = 50)
    private String immeubleAddress;
    @Column
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
     * Relation to the appartments of the immeuble, delete appartment if immeuble deleted is activated.
     */
    @OneToMany(mappedBy = "immeuble", cascade = CascadeType.ALL)
    private List<Appartment> appartments;

}
