package lk.EasyCarRental.backend.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarMaintenanceDTO {

    private Date date;
    private Date returnDate;
    private String description;
    private String carRegNo;
}
