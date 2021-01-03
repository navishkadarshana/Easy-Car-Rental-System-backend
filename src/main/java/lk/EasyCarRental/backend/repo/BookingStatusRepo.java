package lk.EasyCarRental.backend.repo;

import lk.EasyCarRental.backend.entity.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingStatusRepo extends JpaRepository<BookingStatus,String> {
}
