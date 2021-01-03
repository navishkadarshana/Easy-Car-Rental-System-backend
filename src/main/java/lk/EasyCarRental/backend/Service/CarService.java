package lk.EasyCarRental.backend.Service;

import lk.EasyCarRental.backend.dto.CarDTO;
import lk.EasyCarRental.backend.dto.CarImageDTO;
import lk.EasyCarRental.backend.dto.CustomerDTO;

import java.util.List;

public interface CarService {

    void saveCar(CarDTO dto);
    void updateCar(CarDTO dto);
    Object searchCar(String id);
    void deleteCar(String id);
    List<Object> getAllCar();
}
