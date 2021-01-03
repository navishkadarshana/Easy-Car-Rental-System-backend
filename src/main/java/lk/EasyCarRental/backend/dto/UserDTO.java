package lk.EasyCarRental.backend.dto;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO  {

    private String email;
    private String password;
    private String role;
    private String lastLogged;

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
