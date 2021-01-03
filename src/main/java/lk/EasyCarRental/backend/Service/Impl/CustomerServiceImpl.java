package lk.EasyCarRental.backend.Service.Impl;

import lk.EasyCarRental.backend.Service.CustomerService;
import lk.EasyCarRental.backend.dto.CustomerDTO;
import lk.EasyCarRental.backend.dto.UserDTO;
import lk.EasyCarRental.backend.entity.Customer;
import lk.EasyCarRental.backend.entity.User;
import lk.EasyCarRental.backend.repo.CustomerRepo;
import lk.EasyCarRental.backend.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {


        for (UserDTO ud : dto.getUser()) {
            if (!userRepo.existsById(ud.getEmail())){


                User user = new User(ud.getEmail(),ud.getPassword(),ud.getRole(),ud.getLastLogged());
                userRepo.save(user);

             if(!customerRepo.existsById(dto.getNic())){

                 Customer customer = mapper.map(dto, Customer.class);

                 Customer customer1 = new Customer(customer.getNic(), customer.getName(), customer.getAddress(), customer.getContact(),user);

                 customerRepo.save(customer1);
             }else {

                 throw  new RuntimeException(dto.getNic()+" this NIC is already exist!");
             }

            }else {

                throw  new RuntimeException(ud.getEmail()+ " this email is already connected to an account!");
            }

        }

    }

    @Override
    public void updateCustomer(CustomerDTO dto) {

    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        Customer customerByNic = customerRepo.getCustomerByNic(id);
        CustomerDTO cus = mapper.map(customerByNic, CustomerDTO.class);

        return cus;
    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return null;
    }

    @Override
    public void Login(UserDTO dto) {

        if(userRepo.existsUserByEmailAndPassword(dto.getEmail(),dto.getPassword())){

            System.out.println(dto.getEmail());
            System.out.println(dto.getPassword());

            userRepo.Login(dto.getEmail(), dto.getPassword());


        }else {

            throw new RuntimeException("LoginFail");
        }

    }

    @Override
    public Object selectCustomer(String id) {

        System.out.println(id);
        Object customer = customerRepo.selectCustomer(id);
        return customer;
        //System.out.println(customer.getName());
        //return new CustomerDTO(customer.getNic(),customer.getName(),customer.getAddress(),customer.getContact());


    }
}
