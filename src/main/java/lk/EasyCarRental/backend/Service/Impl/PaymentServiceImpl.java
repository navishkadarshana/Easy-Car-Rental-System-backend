package lk.EasyCarRental.backend.Service.Impl;

import lk.EasyCarRental.backend.Service.PaymentService;
import lk.EasyCarRental.backend.dto.PaymentDTO;
import lk.EasyCarRental.backend.entity.Booking;
import lk.EasyCarRental.backend.entity.Payment;
import lk.EasyCarRental.backend.repo.BookingRepo;
import lk.EasyCarRental.backend.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Transactional
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    BookingRepo bookingRepo;

    @Override
    public void savePayment(PaymentDTO dto) {

        Booking booking = bookingRepo.getBookingByBookingNo(Long.parseLong(dto.getBookingCode()));

        Payment payment = new Payment(dto.getAmount(),dto.getPaymentType(),dto.getDeduction(),dto.getTotal(),new Date(),booking);

        paymentRepo.save(payment);
    }

    @Override
    public void updatePayment(PaymentDTO dto) {

    }

    @Override
    public PaymentDTO searchPayment(String id) {
        return null;
    }

    @Override
    public void deletePayment(String id) {

    }

    @Override
    public List<PaymentDTO> getAllPayment() {
        return null;
    }
}
