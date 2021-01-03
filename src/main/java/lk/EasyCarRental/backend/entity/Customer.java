package lk.EasyCarRental.backend.entity;

import lk.EasyCarRental.backend.dto.CustomerDTO;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer{

    @Id
    private String nic;
    private String name;
    private String address;
    private String contact;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private User user;


    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<NICImage> nicImg=new ArrayList<>();


    @OneToMany(mappedBy = "customer")
    private List<Booking> orders = new ArrayList<>();



    public Customer(String nic, String name, String address, String contact, User user) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.user = user;
    }

}
