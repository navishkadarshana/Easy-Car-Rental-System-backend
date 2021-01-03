package lk.EasyCarRental.backend.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReturnCar {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long rid;

   private String returnDate;
   private double usedKm;



   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "bid", referencedColumnName = "bookingNo", nullable = false)
   private Booking booking;

   public ReturnCar(String returnDate, double usedKm, Booking booking) {
      this.returnDate = returnDate;
      this.usedKm = usedKm;
      this.booking = booking;
   }
}

