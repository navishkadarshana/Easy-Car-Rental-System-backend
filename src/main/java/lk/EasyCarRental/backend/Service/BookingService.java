package lk.EasyCarRental.backend.Service;

import lk.EasyCarRental.backend.dto.BankSlipDTO;
import lk.EasyCarRental.backend.dto.BookingDTO;
import lk.EasyCarRental.backend.dto.CarMaintenanceDTO;

import java.util.List;

public interface BookingService {


    void saveBooking(BookingDTO dto, BankSlipDTO bankSlipDTO);
    void updateBooking(BookingDTO dto);
    BookingDTO searchBooking(String id);
    void deleteBooking(String id);
    List<BookingDTO> getAllBooking();
    List<Object> getAllPendingBooking();

}
