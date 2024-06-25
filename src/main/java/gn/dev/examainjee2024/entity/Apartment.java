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

}
