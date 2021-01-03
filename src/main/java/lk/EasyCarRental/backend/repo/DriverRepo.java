package lk.EasyCarRental.backend.repo;

import lk.EasyCarRental.backend.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;
import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String> {

    Driver getAllByDriverNic(String did);

    @Modifying
    @Query("update Driver d set d.status = ?1 where d.driverNic = ?2")
    void setDriverStatus(String status, String regNo);

    @Query(value="SELECT * FROM Driver WHERE status='available' ORDER BY RAND() LIMIT 1  ", nativeQuery = true)
    Driver findDriver();


    @Query(value="SELECT driverNic,name,address,contact,Driveremail,password,status FROM Driver INNER JOIN User ON User.email=Driver.Driveremail;", nativeQuery = true)
    List<Object> getDriver();




}
