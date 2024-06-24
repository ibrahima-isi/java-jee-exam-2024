package gn.dev.examainjee2024.entity;

import javax.persistence.*;

@Entity
@Table
public class Appartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appartmentID;
    @Column
    private String appartmentNumber;
    @Column
    private String numberOfRoom;
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
