package lk.EasyCarRental.backend.Service.Impl;

import lk.EasyCarRental.backend.Service.ReturnCarService;
import lk.EasyCarRental.backend.dto.ReturnCarDTO;
import lk.EasyCarRental.backend.entity.Booking;
import lk.EasyCarRental.backend.entity.ReturnCar;
import lk.EasyCarRental.backend.repo.BookingRepo;
import lk.EasyCarRental.backend.repo.CarRepo;
import lk.EasyCarRental.backend.repo.DriverRepo;
import lk.EasyCarRental.backend.repo.ReturnCarRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReturnCarServiceImpl implements ReturnCarService {

    @Autowired
    ReturnCarRepo returnCarRepo;

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    DriverRepo driverRepo;


    @Override
    public void saveReturnCar(ReturnCarDTO dto) {


        if (bookingRepo.existsBookingByBookingNo(Long.parseLong(dto.getBookingNo()))){

            Booking booking = bookingRepo.getBookingByBookingNo(Long.parseLong(dto.getBookingNo()));

            if(booking.getDriver()!=null){

                carRepo.setCarStatus("available",booking.getCar().getRegNo());

                ReturnCar returnCar=new ReturnCar(dto.getReturnDate(),dto.getUsedKm(),booking);

                driverRepo.setDriverStatus("available",booking.getDriver().getDriverNic());

                returnCarRepo.save(returnCar);


            }else {


                carRepo.setCarStatus("available",booking.getCar().getRegNo());

                ReturnCar returnCar=new ReturnCar(dto.getReturnDate(),dto.getUsedKm(),booking);

                returnCarRepo.save(returnCar);

            }


        }else {

            throw new RuntimeException("Not available booking");
        }

    }

    @Override
    public void updateReturnCar(ReturnCarDTO dto) {

    }

    @Override
    public ReturnCarDTO searchReturnCar(String id) {
        return null;
    }

    @Override
    public void deleteReturnCar(String id) {

    }

    @Override
    public List<ReturnCarDTO> getAllReturnCar() {
        return null;
    }
}
