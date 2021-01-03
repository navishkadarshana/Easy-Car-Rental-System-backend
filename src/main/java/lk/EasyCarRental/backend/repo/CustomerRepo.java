package lk.EasyCarRental.backend.repo;

import lk.EasyCarRental.backend.entity.Customer;
import lk.EasyCarRental.backend.entity.Driver;
import lk.EasyCarRental.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer,String> {


    Customer getCustomerByNic(String id);

    boolean existsCustomerByNic(String id);

    Customer getCustomerByUser(User email);

    @Query(value="SELECT nic,name,email FROM Customer WHERE email=?1", nativeQuery = true)
    Object selectCustomer(String id);




}
