package gn.dev.examainjee2024.dao.interfaces;

import gn.dev.examainjee2024.entity.Location;
import gn.dev.examainjee2024.entity.Payment;
import gn.dev.examainjee2024.entity.User;

import java.util.List;

public interface IPayment {
    public List<Payment> getPayments();
    public Payment getPaymentById(long id);
    public int addPayment(Payment payment);
    public int updatePayment(Payment payment);
    public int deletePayment(long id);
    public User getPaymentOwner();
    public Location getPaymentLocation();
}
