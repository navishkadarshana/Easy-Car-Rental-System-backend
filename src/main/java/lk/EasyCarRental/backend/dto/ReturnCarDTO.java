package lk.EasyCarRental.backend.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReturnCarDTO {

    private String returnDate;
    private double usedKm;
    private String bookingNo;

}
