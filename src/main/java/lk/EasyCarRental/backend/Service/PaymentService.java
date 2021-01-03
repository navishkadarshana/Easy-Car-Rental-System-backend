package lk.EasyCarRental.backend.Service;

import lk.EasyCarRental.backend.dto.DriverDTO;
import lk.EasyCarRental.backend.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    void savePayment(PaymentDTO dto);
    void updatePayment(PaymentDTO dto);
    PaymentDTO searchPayment(String id);
    void deletePayment(String id);
    List<PaymentDTO> getAllPayment();

}
