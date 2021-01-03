package lk.EasyCarRental.backend.Service;

import lk.EasyCarRental.backend.dto.CustomerDTO;
import lk.EasyCarRental.backend.dto.DriverDTO;

import java.util.List;

public interface DriverService {

    void saveDriver(DriverDTO dto);
    void updateDriver(DriverDTO dto);
    DriverDTO searchDriver(String id);
    void deleteDriver(String id);
    List<Object> getAllDriver();
}
