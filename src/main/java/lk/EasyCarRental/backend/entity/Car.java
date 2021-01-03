package lk.EasyCarRental.backend.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Car {

 @Id
 @GeneratedValue(generator = "uuid2")
 @GenericGenerator(name = "uuid2", strategy = "uuid2")
 @Column(columnDefinition = "BINARY(16)")
   private UUID carId;


    private String regNo;
    private int noOfPassenger;
    private String type;
    private String fuelType;
    private String brand;
    private String color;
    private String transmissionType;
    private double extraKmPrice;
    private String status;


    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<CarImage> carImages;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<CarFreeMileage> carFreeMileages;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<CarMaintenance> carMaintenances;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<CarPriceForRentDuration> carPriceForRentDurations;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();


 public Car(String regNo, int noOfPassenger, String type, String fuelType, String brand, String color, String transmissionType, double extraKmPrice, String status) {
  this.regNo = regNo;
  this.noOfPassenger = noOfPassenger;
  this.type = type;
  this.fuelType = fuelType;
  this.brand = brand;
  this.color = color;
  this.transmissionType = transmissionType;
  this.extraKmPrice = extraKmPrice;
  this.status=status;
 }

}
