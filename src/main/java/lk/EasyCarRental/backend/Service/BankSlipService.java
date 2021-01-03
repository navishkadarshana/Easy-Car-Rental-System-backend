package lk.EasyCarRental.backend.Service;

import lk.EasyCarRental.backend.dto.BankSlipDTO;
import lk.EasyCarRental.backend.dto.BookingDTO;

import java.util.List;

public interface BankSlipService {


    void saveBankSlip(BankSlipDTO dto);
    void updateBankSlip(BankSlipDTO dto);
    BookingDTO searchBankSlip(String id);
    void deleteBankSlip(String id);
    List<BankSlipDTO> getAllBankSlip();
}
