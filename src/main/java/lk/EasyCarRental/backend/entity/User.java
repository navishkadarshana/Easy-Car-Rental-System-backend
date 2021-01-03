package lk.EasyCarRental.backend.entity;

import lk.EasyCarRental.backend.dto.CustomerDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User{
    @Id
    private String email;
    private String password;
    private String role;
    private String lastLogged;



    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Customer customer;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Driver driver;


    public User(String email, String password, String role, String lastLogged) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.lastLogged = lastLogged;
    }
}
