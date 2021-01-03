package lk.EasyCarRental.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Driver {


    @Id
    private String driverNic;
    private String name;
    private String address;
    private String contact;
    private String status;


    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Driveremail", referencedColumnName = "email", nullable = false)
    private User user;

    public Driver(String driverNic, String name, String address, String contact) {
        this.driverNic = driverNic;
        this.name = name;
        this.address = address;
        this.contact = contact;

    }


    public Driver(String driverNic, String name, String address, String contact, String status, User user) {
        this.driverNic = driverNic;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.user = user;
        this.status = status;
    }
}
