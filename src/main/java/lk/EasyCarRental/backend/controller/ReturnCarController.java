package lk.EasyCarRental.backend.controller;


import lk.EasyCarRental.backend.Service.ReturnCarService;
import lk.EasyCarRental.backend.dto.ReturnCarDTO;
import lk.EasyCarRental.backend.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/returns")
@CrossOrigin
public class ReturnCarController {

    @Autowired
    ReturnCarService returnCarService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveDriver(@RequestBody ReturnCarDTO dto){

        returnCarService.saveReturnCar(dto);
        StandradResponse success = new StandradResponse(200, "success", null);
        return new ResponseEntity(success, HttpStatus.OK);


    }
}
