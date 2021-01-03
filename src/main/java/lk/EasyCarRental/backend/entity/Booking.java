package lk.EasyCarRental.backend.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingNo;

    private Date BookingDateTime;
    private Date dateRequired;
    private Date returnDate;


    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<BookingStatus> orderStatus;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cid", referencedColumnName = "nic", nullable = false)
    private Customer customer;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "driverID", referencedColumnName = "driverNic", nullable = true)
    private Driver driver;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carId", referencedColumnName = "carId", nullable = false)
    private Car car;


    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private BankSlip bankSlipImage;


    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private ReturnCar returnCar;





    public Booking(Date bookingDateTime, Date dateRequired, Date returnDate, Customer customer, Driver driver,Car car) {
        BookingDateTime = bookingDateTime;
        this.dateRequired = dateRequired;
        this.returnDate = returnDate;
        this.customer = customer;
        this.driver = driver;
        this.car=car;

    }
}
