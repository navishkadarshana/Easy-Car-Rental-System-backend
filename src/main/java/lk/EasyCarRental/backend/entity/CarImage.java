package lk.EasyCarRental.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CarImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long car_image_id;

    private String car_image_path;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carCode", referencedColumnName = "carId", nullable = false)
    private Car car;

    public CarImage(String car_image_path, Car car) {
        this.car_image_path = car_image_path;
        this.car = car;
    }
}
