package lk.EasyCarRental.backend.repo;

import lk.EasyCarRental.backend.entity.ReturnCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnCarRepo extends JpaRepository<ReturnCar,String> {
}
