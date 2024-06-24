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
     * This is the relation between the appartment and the immeuble, immeuble is so a foreign key
     */
    @ManyToOne
    @JoinColumn(name = "immeuble_id")
    private Immeuble immeuble;

}
