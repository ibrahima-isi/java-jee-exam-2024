package gn.dev.examainjee2024.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.YearMonth;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
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

    public Payment() {
    }

    public Payment(Location location, YearMonth month, LocalDate paymentDate, long paymentID, boolean status, User user) {
        this.location = location;
        this.month = month;
        this.paymentDate = paymentDate;
        this.paymentID = paymentID;
        this.status = status;
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public YearMonth getMonth() {
        return month;
    }

    public void setMonth(YearMonth month) {
        this.month = month;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public long getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(long paymentID) {
        this.paymentID = paymentID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Payment{" +
                ", paymentID=" + paymentID +
                "location=" + location +
                ", month=" + month +
                ", paymentDate=" + paymentDate +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
