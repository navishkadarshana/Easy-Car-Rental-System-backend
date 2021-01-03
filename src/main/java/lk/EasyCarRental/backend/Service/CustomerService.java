package lk.EasyCarRental.backend.Service;

import lk.EasyCarRental.backend.dto.CustomerDTO;
import lk.EasyCarRental.backend.dto.UserDTO;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    CustomerDTO searchCustomer(String id);
    void deleteCustomer(String id);
    List<CustomerDTO> getAllCustomer();
    void  Login (UserDTO dto);
    Object selectCustomer(String id);
}
