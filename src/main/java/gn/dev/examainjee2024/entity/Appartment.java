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

    @ManyToOne
    @JoinColumn(name = "immeubleID")
    private Immeuble immeuble;

}
