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
     * the status of the entity, if defined to true then the entity will be listed, if not, he will be in archived
     */
    @Column(columnDefinition = "boolean default true")
    private boolean status;

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
