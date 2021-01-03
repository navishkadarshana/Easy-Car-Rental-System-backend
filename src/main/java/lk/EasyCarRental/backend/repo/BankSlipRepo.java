package lk.EasyCarRental.backend.repo;

import lk.EasyCarRental.backend.entity.BankSlip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankSlipRepo extends JpaRepository<BankSlip,String> {
}
