package lk.EasyCarRental.backend.Service.Impl;

import lk.EasyCarRental.backend.Service.CarImageService;
import lk.EasyCarRental.backend.dto.CarImageDTO;
import lk.EasyCarRental.backend.entity.Car;
import lk.EasyCarRental.backend.entity.CarImage;
import lk.EasyCarRental.backend.repo.CarImageRepo;
import lk.EasyCarRental.backend.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarImageServiceImpl implements CarImageService {

    @Autowired
    CarImageRepo carImageRepo;

    @Autowired
    CarRepo carRepo;

    @Override
    public void saveCarImage(CarImageDTO dto) {

        Car car = carRepo.getCarByRegNo(dto.getCar_id());

        CarImage carImage=new CarImage(dto.getCar_image_path(),car);
        carImageRepo.save(carImage);

    }
}
