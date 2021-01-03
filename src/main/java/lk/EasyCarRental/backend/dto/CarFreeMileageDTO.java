package lk.EasyCarRental.backend.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarFreeMileageDTO {

    private double price;
    private int duration;
}
