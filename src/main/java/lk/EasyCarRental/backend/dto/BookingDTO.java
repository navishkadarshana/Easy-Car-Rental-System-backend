package lk.EasyCarRental.backend.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingDTO {

    private Date dateRequired;
    private Date returnDate;
    private String cusId;
    private String driver;
    private String carRegNo;
    private ArrayList<BookingStatusDTO> bookingStatus=new ArrayList<>();

}
