package lk.EasyCarRental.backend.Service.Impl;

import lk.EasyCarRental.backend.Service.CarService;
import lk.EasyCarRental.backend.dto.CarDTO;
import lk.EasyCarRental.backend.dto.CarFreeMileageDTO;
import lk.EasyCarRental.backend.dto.CarImageDTO;
import lk.EasyCarRental.backend.dto.CarPriceForRentDurationDTO;
import lk.EasyCarRental.backend.entity.*;
import lk.EasyCarRental.backend.repo.CarFreeMileageRepo;
import lk.EasyCarRental.backend.repo.CarImageRepo;
import lk.EasyCarRental.backend.repo.CarPriceForRentDurationRepo;
import lk.EasyCarRental.backend.repo.CarRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    CarRepo carRepo;

    @Autowired
    CarFreeMileageRepo carFreeMileageRepo;

    @Autowired
    CarPriceForRentDurationRepo carPriceForRentDurationRepo;

    @Autowired
    CarImageRepo carImageRepo;





    @Override
    public void saveCar(CarDTO dto) {


        if (!carRepo.existsCarByRegNo(dto.getRegNo())){


            Car car = new Car(dto.getRegNo(),dto.getNoOfPassenger(),dto.getType(),dto.getFuelType(),dto.getBrand(),dto.getColor(),dto.getTransmissionType(),dto.getExtraKmPrice(),dto.getStatus());
            carRepo.save(car);



            for (CarPriceForRentDurationDTO d :dto.getCarPriceForRentDuration()){


                CarPriceForRentDuration priceForRentDuration=new CarPriceForRentDuration(d.getDailyRate(),d.getMonthlyRate(),car);
                carPriceForRentDurationRepo.save(priceForRentDuration);
            }

            for (CarFreeMileageDTO m : dto.getCarFreeMileage()){


                CarFreeMileage carFreeMileage= new CarFreeMileage(m.getPrice(),m.getDuration(),car);
                carFreeMileageRepo.save(carFreeMileage);


            }


        }else {

            throw new RuntimeException("this car allready registered");
        }

    }

    @Override
    public void updateCar(CarDTO dto) {

    }

    @Override
    public List<Object> searchCar(String id) {

        List<Object> carAllByRegNo = carRepo.getCarAllByRegNo(id);
        return carAllByRegNo;
    }

    @Override
    public void deleteCar(String id) {

    }

    @Override
    public List<Object> getAllCar() {



        List<Object> car = carRepo.getCar1();

        return car;
    }
}
