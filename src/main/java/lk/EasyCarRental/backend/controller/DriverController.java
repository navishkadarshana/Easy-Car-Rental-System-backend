package lk.EasyCarRental.backend.controller;


import lk.EasyCarRental.backend.Service.DriverService;
import lk.EasyCarRental.backend.dto.CustomerDTO;
import lk.EasyCarRental.backend.dto.DriverDTO;
import lk.EasyCarRental.backend.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveDriver(@RequestBody DriverDTO dto){

        driverService.saveDriver(dto);
        StandradResponse success = new StandradResponse(200, "success", null);
        return new ResponseEntity(success, HttpStatus.OK);


    }



    @GetMapping
    public ResponseEntity<StandradResponse> getAllDriver(){

        List<Object> allDriver = driverService.getAllDriver();
        StandradResponse success = new StandradResponse(200, "success", allDriver);
        return new ResponseEntity(success, HttpStatus.OK);
    }




}
