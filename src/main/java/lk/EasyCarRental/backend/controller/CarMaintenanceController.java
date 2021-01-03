package lk.EasyCarRental.backend.controller;

import lk.EasyCarRental.backend.Service.CarMaintenanceService;
import lk.EasyCarRental.backend.dto.CarMaintenanceDTO;
import lk.EasyCarRental.backend.dto.CustomerDTO;
import lk.EasyCarRental.backend.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/CarMaintenanceController")
@CrossOrigin
public class CarMaintenanceController {

    @Autowired
    CarMaintenanceService carMaintenanceService;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveCustomer(@RequestBody CarMaintenanceDTO dto){

       carMaintenanceService.saveCarMaintenance(dto);
        StandradResponse success = new StandradResponse(200, "success", null);
        return new ResponseEntity(success, HttpStatus.OK);

    }

}


