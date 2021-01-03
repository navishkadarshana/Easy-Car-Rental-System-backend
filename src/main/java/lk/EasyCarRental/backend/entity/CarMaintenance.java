package lk.EasyCarRental.backend.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CarMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maintenanceId;

    private Date date;
    private Date returnDate;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carId", referencedColumnName = "carId", nullable = false)
    private Car car;


    public CarMaintenance(Date date, Date returnDate, String description, Car car) {
        this.date = date;
        this.returnDate = returnDate;
        this.description = description;
        this.car = car;
    }
}
