package lk.EasyCarRental.backend.repo;

import lk.EasyCarRental.backend.entity.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepo extends JpaRepository<CarImage,String> {
}
