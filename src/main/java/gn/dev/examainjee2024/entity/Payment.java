package gn.dev.examainjee2024.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.YearMonth;

@Entity
@Table
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentID;
    /**
     * the month that have been paid
     */
    @Column
    private YearMonth month;
    /**
     * The day that the payment have been made.
     */
    @Column
    private LocalDate paymentDate;

    /**
     * the status of the entity, if defined to true then the entity will be listed, if not, he will be in archived
     */
    @Column(columnDefinition = "boolean default true")
    private boolean status;

    /**
     * Relation to the user who made this payment
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Relation to the location that have been paid by this payment
     */
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

}
