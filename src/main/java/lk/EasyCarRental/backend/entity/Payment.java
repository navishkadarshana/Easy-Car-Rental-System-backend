package lk.EasyCarRental.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payId;

    private double amount;
    private String PaymentType;
    private double deduction;
    private double total;
    private Date date;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BookingId", referencedColumnName = "bookingNo", nullable = false)
    private Booking booking;


    public Payment(double amount, String paymentType, double deduction, double total, Date date, Booking booking) {
        this.amount = amount;
        PaymentType = paymentType;
        this.deduction = deduction;
        this.total = total;
        this.date = date;
        this.booking = booking;
    }
}
