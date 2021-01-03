package lk.EasyCarRental.backend.Service.Impl;

import lk.EasyCarRental.backend.Service.DriverService;
import lk.EasyCarRental.backend.dto.CustomerDTO;
import lk.EasyCarRental.backend.dto.DriverDTO;
import lk.EasyCarRental.backend.dto.UserDTO;
import lk.EasyCarRental.backend.entity.Customer;
import lk.EasyCarRental.backend.entity.Driver;
import lk.EasyCarRental.backend.entity.User;
import lk.EasyCarRental.backend.repo.DriverRepo;
import lk.EasyCarRental.backend.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper mapper;


    @Override
    public void saveDriver(DriverDTO dto) {


        for (UserDTO ud : dto.getUser()) {

            if (!userRepo.existsById(ud.getEmail())){

                User user = new User(ud.getEmail(),ud.getPassword(),ud.getRole(),ud.getLastLogged());
                userRepo.save(user);


                if (!driverRepo.existsById(dto.getDriverNic())){

                    Driver d = new Driver(dto.getDriverNic(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getStatus(),user);
                    driverRepo.save(d);

                }else {

                    throw  new RuntimeException(dto.getDriverNic()+" this NIC is already exist!");
                }


            }else {

                throw  new RuntimeException(ud.getEmail()+ " this email is already connected to an account!");

            }

        }

    }

    @Override
    public void updateDriver(DriverDTO dto) {

    }

    @Override
    public DriverDTO searchDriver(String id) {
        return null;
    }

    @Override
    public void deleteDriver(String id) {

    }

    @Override
    public List<Object> getAllDriver() {

        List<Object> driver = driverRepo.getDriver();

        return driver;
    }
}
