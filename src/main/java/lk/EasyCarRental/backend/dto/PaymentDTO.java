package lk.EasyCarRental.backend.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentDTO {

    private double amount;
    private String PaymentType;
    private double deduction;
    private double total;
    private String bookingCode;

}
