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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "immeuble", cascade = CascadeType.ALL)
    private List<Appartment> appartments;

}
