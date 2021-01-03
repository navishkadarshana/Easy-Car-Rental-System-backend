package lk.EasyCarRental.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CarFreeMileage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long freeMileageId;

    private double price;
    private int duration;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carId", referencedColumnName = "carId", nullable = false)
    private Car car;


   public CarFreeMileage(double price, int duration, Car car) {
        this.price = price;
        this.duration = duration;
        this.car = car;
    }
}
