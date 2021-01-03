package lk.EasyCarRental.backend.Service.Impl;

import lk.EasyCarRental.backend.Service.NicImageService;
import lk.EasyCarRental.backend.dto.NicImageDTO;
import lk.EasyCarRental.backend.entity.Customer;
import lk.EasyCarRental.backend.entity.NICImage;
import lk.EasyCarRental.backend.repo.CustomerRepo;
import lk.EasyCarRental.backend.repo.NicImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NicImageImpl implements NicImageService {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    NicImageRepo nicImageRepo;


    @Override
    public void saveReturnCar(NicImageDTO dto) {


        Customer customer = customerRepo.getCustomerByNic(dto.getCustomer_id());

        NICImage nicImage=new NICImage(dto.getNic_id(),dto.getImage_path(),customer);
        nicImageRepo.save(nicImage);


    }
}
