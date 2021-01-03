package lk.EasyCarRental.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class BankSlip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bank_slip_id;

    private String image_path;

    @OneToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "bookingNo")
    private Booking booking;


    public BankSlip(String image_path, Booking booking) {
        this.image_path = image_path;
        this.booking = booking;
    }
}

