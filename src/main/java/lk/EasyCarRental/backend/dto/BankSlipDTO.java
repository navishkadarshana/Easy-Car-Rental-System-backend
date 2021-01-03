package lk.EasyCarRental.backend.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BankSlipDTO {

    private String bank_slip_id;
    private String image_path;
    private String booking_id;

    public BankSlipDTO(String image_path, String booking_id) {
        this.image_path = image_path;
        this.booking_id = booking_id;
    }
}
