package lk.EasyCarRental.backend.Service;

import lk.EasyCarRental.backend.dto.CarDTO;
import lk.EasyCarRental.backend.dto.CarMaintenanceDTO;

import java.util.List;

public interface CarMaintenanceService {

    void saveCarMaintenance(CarMaintenanceDTO dto);
    void updateCarMaintenance(CarMaintenanceDTO dto);
    CarMaintenanceDTO searchCarMaintenance(String id);
    void deleteCarMaintenance(String id);
    List<CarMaintenanceDTO> getAllCarMaintenance();
}
