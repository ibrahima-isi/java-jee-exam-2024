package gn.dev.examainjee2024.entity;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "userID")
    private User userID;

    @OneToMany(mappedBy = "immeuble")

}
