package lk.EasyCarRental.backend.repo;

import lk.EasyCarRental.backend.entity.CarMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarMaintenanceRepo extends JpaRepository<CarMaintenance,String> {
}
