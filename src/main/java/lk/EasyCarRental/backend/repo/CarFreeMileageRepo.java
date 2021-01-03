package lk.EasyCarRental.backend.repo;

import lk.EasyCarRental.backend.entity.CarFreeMileage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarFreeMileageRepo extends JpaRepository<CarFreeMileage,String> {
}
