package lk.EasyCarRental.backend.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class NICImage {
    @Id
    private String nic_id;
    private String image_path;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cusID", referencedColumnName = "nic", nullable = true)
    private Customer customer;

}
