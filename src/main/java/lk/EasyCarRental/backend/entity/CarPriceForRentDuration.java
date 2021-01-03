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
public class CarPriceForRentDuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pfrdId;

    private double monthlyRate;
    private double dailyRate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carId", referencedColumnName = "carId", nullable = false)
    private Car car;

    public CarPriceForRentDuration(double monthlyRate, double dailyRate, Car car) {
        this.monthlyRate = monthlyRate;
        this.dailyRate = dailyRate;
        this.car = car;
    }
}
