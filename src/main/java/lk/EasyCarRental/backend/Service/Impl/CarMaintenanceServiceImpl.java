package lk.EasyCarRental.backend.Service.Impl;

import lk.EasyCarRental.backend.Service.CarMaintenanceService;
import lk.EasyCarRental.backend.dto.CarMaintenanceDTO;
import lk.EasyCarRental.backend.entity.Car;
import lk.EasyCarRental.backend.entity.CarMaintenance;
import lk.EasyCarRental.backend.repo.CarMaintenanceRepo;
import lk.EasyCarRental.backend.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class CarMaintenanceServiceImpl implements CarMaintenanceService {

    @Autowired
    CarMaintenanceRepo carMaintenanceRepo;

    @Autowired
    CarRepo carRepo;



    @Override
    public void saveCarMaintenance(CarMaintenanceDTO dto) {


        if (carRepo.existsCarByRegNo(dto.getCarRegNo())){

            Car car = carRepo.getCarByRegNo(dto.getCarRegNo());
            CarMaintenance carMaintenance = new CarMaintenance(dto.getDate(), dto.getReturnDate(), dto.getDescription(), car);
            carMaintenanceRepo.save(carMaintenance);

        }else {

            throw  new RuntimeException("This car No Not Regiserd");

        }


    }

    @Override
    public void updateCarMaintenance(CarMaintenanceDTO dto) {

    }

    @Override
    public CarMaintenanceDTO searchCarMaintenance(String id) {
        return null;
    }

    @Override
    public void deleteCarMaintenance(String id) {

    }

    @Override
    public List<CarMaintenanceDTO> getAllCarMaintenance() {
        return null;
    }
}
