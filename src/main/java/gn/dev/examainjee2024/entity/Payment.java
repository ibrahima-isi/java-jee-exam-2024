package gn.dev.examainjee2024.entity;

import javax.persistence.*;

@Entity
@Table
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentID;

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

}
