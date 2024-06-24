package gn.dev.examainjee2024.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long locationID;

    /**
     * Relation to the tenant of the location
     */
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private User user;

    /**
     * Relation to the appartment of the location
     */
    @ManyToOne
    @JoinColumn(name = "appartment_id")
    private Appartment appartment;

    /**
     * The timestamp is on LocalTime so that we can have the hour if needed
     */
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate locationDate;
}
