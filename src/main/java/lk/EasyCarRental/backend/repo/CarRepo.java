package lk.EasyCarRental.backend.repo;

import lk.EasyCarRental.backend.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepo extends JpaRepository <Car, String>{

    boolean existsCarByRegNo(String Rno);

    Car getCarByRegNo(String rno);


    @Modifying
    @Query("update Car c set c .status = ?1 where c.regNo = ?2")
    void setCarStatus(String status, String regNo);


    @Query(value="SELECT regNo,brand,color,status,car_image_path FROM Car " +
            "INNER JOIN CarImage ON CarImage.carCode=Car.carId;", nativeQuery = true)
    List<Object> getCar1();


    @Query(value="SELECT regNo,brand,color,fuelType,noOfPassenger,type,extraKmPrice,status,dailyRate,monthlyRate,car_image_path  FROM Car \n" +
            "   INNER JOIN CarImage\n" +
            "     ON CarImage.carCode=Car.carId\n" +
            "    INNER JOIN CarPriceForRentDuration ON CarPriceForRentDuration.carId=Car.carId\n" +
            " WHERE regNo =?1", nativeQuery = true)
     List<Object> getCarAllByRegNo(String id);



}
