package lk.EasyCarRental.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookingStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    private String BookingType;
    private String description;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BookingID", referencedColumnName = "bookingNo", nullable = false)
    private Booking booking;


    public BookingStatus(String BookingType, String description, Booking booking) {
        this.BookingType = BookingType;
        this.description = description;
        this.booking = booking;
    }
}
