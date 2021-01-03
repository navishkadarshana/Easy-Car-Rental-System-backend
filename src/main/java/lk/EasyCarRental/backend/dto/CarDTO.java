package lk.EasyCarRental.backend.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDTO {
    private String regNo;
    private int noOfPassenger;
    private String type;
    private String fuelType;
    private String brand;
    private String color;
    private String transmissionType;
    private double extraKmPrice;
    private String status;
    private ArrayList<CarPriceForRentDurationDTO>carPriceForRentDuration=new ArrayList<>();
    private ArrayList<CarFreeMileageDTO>carFreeMileage=new ArrayList<>();


    public CarDTO(String regNo, int noOfPassenger, String type, String fuelType, String brand, String color, String transmissionType, double extraKmPrice, String status) {
        this.regNo = regNo;
        this.noOfPassenger = noOfPassenger;
        this.type = type;
        this.fuelType = fuelType;
        this.brand = brand;
        this.color = color;
        this.transmissionType = transmissionType;
        this.extraKmPrice = extraKmPrice;
        this.status = status;
    }
}
