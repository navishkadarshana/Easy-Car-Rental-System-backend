package lk.EasyCarRental.backend.repo;

import lk.EasyCarRental.backend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,String> {


}
