package lk.EasyCarRental.backend.Service.Impl;
import lk.EasyCarRental.backend.Service.BookingService;
import lk.EasyCarRental.backend.dto.BankSlipDTO;
import lk.EasyCarRental.backend.dto.BookingDTO;
import lk.EasyCarRental.backend.dto.BookingStatusDTO;
import lk.EasyCarRental.backend.entity.*;
import lk.EasyCarRental.backend.repo.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    BookingStatusRepo statusRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    CarRepo carRepo;

    @Autowired
    BankSlipRepo bankSlipRepo;


    @Override
    public void saveBooking(BookingDTO dto, BankSlipDTO bankSlipDTO) {

        Driver driver = driverRepo.findDriver();
        Car car = carRepo.getCarByRegNo(dto.getCarRegNo());
        Customer customer = customerRepo.getCustomerByNic(dto.getCusId());

        if (dto.getDriver().equals("yes")){

            if (car.getStatus().equals("available")){

                Booking booking = new Booking(new Date(),dto.getDateRequired(),dto.getReturnDate(),customer,driver,car);
                Booking bokings = bookingRepo.save(booking);
                for (BookingStatusDTO b : dto.getBookingStatus()){

                    BookingStatus bookingStatus = new BookingStatus(b.getType(),b.getDescription(),booking);

                    statusRepo.save(bookingStatus);

                    //carRepo.setCarStatus("not_available",car.getRegNo());

                    //driverRepo.setDriverStatus("not_available",driver.getDriverNic());

                    BankSlip bankSlip = new BankSlip(bankSlipDTO.getImage_path(),bokings);

                    bankSlipRepo.save(bankSlip);

                }

            }else {

                throw new RuntimeException("this Car not available");
            }
        }else{

            if (car.getStatus().equals("available")){

                Booking booking = new Booking(new Date(),dto.getDateRequired(),dto.getReturnDate(),customer,null,car);
                Booking bokings = bookingRepo.save(booking);
                for (BookingStatusDTO b : dto.getBookingStatus()){

                    BookingStatus bookingStatus = new BookingStatus(b.getType(),b.getDescription(),booking);

                    statusRepo.save(bookingStatus);

                    //carRepo.setCarStatus("not_available",car.getRegNo());

                    BankSlip bankSlip = new BankSlip(bankSlipDTO.getImage_path(),bokings);

                    bankSlipRepo.save(bankSlip);

                }




            }else {

                throw new RuntimeException("this Car not activable");
            }
        }


    }

    @Override
    public void updateBooking(BookingDTO dto) {

    }

    @Override
    public BookingDTO searchBooking(String id) {
        return null;
    }

    @Override
    public void deleteBooking(String id) {

    }

    @Override
    public List<BookingDTO> getAllBooking() {
        return null;
    }

    @Override
    public List<Object> getAllPendingBooking() {

        return null;
    }
}
