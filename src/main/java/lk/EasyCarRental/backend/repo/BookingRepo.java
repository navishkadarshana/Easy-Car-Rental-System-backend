package lk.EasyCarRental.backend.repo;

import lk.EasyCarRental.backend.dto.CustomerDTO;
import lk.EasyCarRental.backend.entity.Booking;
import lk.EasyCarRental.backend.entity.Car;
import lk.EasyCarRental.backend.entity.Customer;
import lk.EasyCarRental.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,String> {

 Booking getBookingByBookingNo(Long id);

 boolean existsBookingByBookingNo(Long id);

/* Booking getBookingByCustomerAndCarAndDateRequired(String cus, String car, Date date);*/

 Booking getBookingByCar(CustomerDTO customerDTO);

 @Query(value="SELECT bookingNo,BookingDateTime,dateRequired,returnDate,regNo,BookingType,description,image_path FROM Booking INNER JOIN Car ON Car.carId=Booking.carId\n" +
         "INNER JOIN BookingStatus ON BookingStatus.BookingID=Booking.bookingNo\n" +
         "INNER JOIN BankSlip ON BankSlip.booking_id=Booking.bookingNo WHERE BookingType ='panding';", nativeQuery = true)
 List<Object> getAllPendingBooking();

}
