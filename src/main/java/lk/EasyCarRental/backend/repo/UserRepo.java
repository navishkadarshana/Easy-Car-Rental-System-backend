package lk.EasyCarRental.backend.repo;

import lk.EasyCarRental.backend.entity.Customer;
import lk.EasyCarRental.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,String> {

    boolean existsUserByEmailAndPassword(String email,String password);

    @Query(value = "SELECT * FROM User WHERE email=?1 AND password=?2",nativeQuery = true)
    User Login(String email, String password);

}
