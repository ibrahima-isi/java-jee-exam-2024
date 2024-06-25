package gn.dev.examainjee2024.entity;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
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
     * Relation to the apartment of the location
     */
    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    /**
     * The timestamp is on LocalTime so that we can have the hour if needed
     */
    @Column
    private LocalDate locationDate;
}
