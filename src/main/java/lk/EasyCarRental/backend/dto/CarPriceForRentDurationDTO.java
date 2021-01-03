package lk.EasyCarRental.backend.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarPriceForRentDurationDTO {

    private double monthlyRate;
    private double dailyRate;

}
