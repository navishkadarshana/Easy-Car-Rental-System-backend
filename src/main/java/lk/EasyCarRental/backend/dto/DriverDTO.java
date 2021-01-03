package lk.EasyCarRental.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class DriverDTO {

    private String driverNic;
    private String name;
    private String address;
    private String contact;
    private String status;
    private ArrayList<UserDTO> user = new ArrayList<>();


    public DriverDTO(String driverNic, String name, String address, String contact, String status) {
        this.driverNic = driverNic;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.status = status;
    }
}
