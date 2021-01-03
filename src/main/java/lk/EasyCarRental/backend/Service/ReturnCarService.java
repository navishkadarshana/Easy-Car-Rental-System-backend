package lk.EasyCarRental.backend.Service;

import lk.EasyCarRental.backend.dto.ReturnCarDTO;

import java.util.List;

public interface ReturnCarService {

    void saveReturnCar(ReturnCarDTO dto);
    void updateReturnCar(ReturnCarDTO dto);
    ReturnCarDTO searchReturnCar(String id);
    void deleteReturnCar(String id);
    List<ReturnCarDTO> getAllReturnCar();

}
