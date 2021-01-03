package lk.EasyCarRental.backend.controller;


import lk.EasyCarRental.backend.Service.PaymentService;
import lk.EasyCarRental.backend.dto.CustomerDTO;
import lk.EasyCarRental.backend.dto.PaymentDTO;
import lk.EasyCarRental.backend.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveCustomer(@RequestBody PaymentDTO dto){

        paymentService.savePayment(dto);
        StandradResponse success = new StandradResponse(200, "success", null);
        return new ResponseEntity(success, HttpStatus.OK);

    }

}
