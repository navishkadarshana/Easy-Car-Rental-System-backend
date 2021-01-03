package lk.EasyCarRental.backend.Service.Impl;

import lk.EasyCarRental.backend.Service.BankSlipService;
import lk.EasyCarRental.backend.dto.BankSlipDTO;
import lk.EasyCarRental.backend.dto.BookingDTO;
import lk.EasyCarRental.backend.entity.BankSlip;
import lk.EasyCarRental.backend.entity.Booking;
import lk.EasyCarRental.backend.repo.BankSlipRepo;
import lk.EasyCarRental.backend.repo.BookingRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankSlipServiceImpl implements BankSlipService {

    @Autowired
    ModelMapper mapper;


    @Autowired
    BankSlipRepo bankSlipRepo;


    @Autowired
    BookingRepo bookingRepo;


    @Override
    public void saveBankSlip(BankSlipDTO dto) {




    }

    @Override
    public void updateBankSlip(BankSlipDTO dto) {

    }

    @Override
    public BookingDTO searchBankSlip(String id) {
        return null;
    }

    @Override
    public void deleteBankSlip(String id) {

    }

    @Override
    public List<BankSlipDTO> getAllBankSlip() {
        return null;
    }
}
