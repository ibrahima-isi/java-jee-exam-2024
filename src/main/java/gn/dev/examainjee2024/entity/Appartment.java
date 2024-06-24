package gn.dev.examainjee2024.entity;

import javax.persistence.*;

@Entity
@Table(name = "appartments")
public class Appartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appartment_id")
    private long appartmentID;
    @Column(length = 5)
    private String appartmentNumber;
    @Column(length = 10)
    private String numberOfRoom;
    /**
     * The area of the appartments, integer
     */
    @Column
    private double surfaceArea;
    /**
     * the status of the entity, if defined to true then the entity will be listed, if not, he will be in archived
     */
    @Column(columnDefinition = "boolean default true")
    private boolean status;

    /**
     * This is the relation between the appartment and the immeuble, immeuble is so a foreign key
     */
    @ManyToOne
    @JoinColumn(name = "immeuble_id")
    private Immeuble immeuble;

}
