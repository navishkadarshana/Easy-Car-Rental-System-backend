package lk.EasyCarRental.backend.dto;

import lombok.*;

import java.util.ArrayList;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerDTO {

    private String nic;
    private String name;
    private String address;
    private String contact;
    private ArrayList<UserDTO> user = new ArrayList<>();

    public CustomerDTO(String nic, String name, String address, String contact) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }



   /* public CustomerDTO(String nic, String name, String address, String contact, String nicImage) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.nicImage = nicImage;
    }*/
}
