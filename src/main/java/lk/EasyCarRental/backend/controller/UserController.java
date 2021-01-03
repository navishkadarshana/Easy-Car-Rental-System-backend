package lk.EasyCarRental.backend.controller;


import lk.EasyCarRental.backend.Service.CustomerService;
import lk.EasyCarRental.backend.dto.CustomerDTO;
import lk.EasyCarRental.backend.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    CustomerService customerService;


    @GetMapping(params = {"email"})
    public ResponseEntity selectedCustomer(@RequestParam("email") String email){

        Object cus = customerService.selectCustomer(email);
        StandradResponse success = new StandradResponse(200, "success", cus);
        return new ResponseEntity(success, HttpStatus.OK);
    }

}


