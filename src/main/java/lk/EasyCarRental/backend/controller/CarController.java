package lk.EasyCarRental.backend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lk.EasyCarRental.backend.Service.CarImageService;
import lk.EasyCarRental.backend.Service.CarService;
import lk.EasyCarRental.backend.dto.*;
import lk.EasyCarRental.backend.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/car")
@CrossOrigin
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    CarImageService carImageService;



    private static final String UPLOADED_FOLDER = "/home/navi/Project Files/IntellijIDEA Project/Car Rental System/Car Rental System Fronend/Frontend/assests/Image/CarImage/";



/*    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveCustomer(@RequestBody CarDTO dto){

        carService.saveCar(dto);
        StandradResponse success = new StandradResponse(200, "success", null);
        return new ResponseEntity(success, HttpStatus.OK);

    }*/
@PostMapping(path = "/{upload}")
public ResponseEntity upload(@RequestParam("file") MultipartFile[] file, @RequestParam("id") String id) throws JsonProcessingException {

    ObjectMapper mapper =new ObjectMapper();

    CarDTO carDTO=mapper.readValue(id,CarDTO.class);

    carService.saveCar(carDTO);

    for (MultipartFile files : file) {

        String fileNames = UUID.randomUUID().toString();
        String contentType = files.getContentType();
        String[] split = contentType.split("/");

        File destinationFile = new File(UPLOADED_FOLDER + fileNames + "." + split[1]);

        try {

            files.transferTo(destinationFile);

            CarImageDTO carImage = new CarImageDTO("assests/Image/CarImage/"+fileNames+"."+split[1],carDTO.getRegNo());
            carImageService.saveCarImage(carImage);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    StandradResponse response = new StandradResponse(200, "Success", null);
    return new ResponseEntity(response, HttpStatus.CREATED);
}



    @GetMapping
    public ResponseEntity getAllCar(){

        List<Object> allDriver = carService.getAllCar();
        StandradResponse success = new StandradResponse(200, "success", allDriver);
        return new ResponseEntity(success, HttpStatus.OK);

    }


    @GetMapping(path = "/{id}")
    public ResponseEntity searchCustomer(@PathVariable String id){

        Object o = carService.searchCar(id);
        StandradResponse success = new StandradResponse(200, "success", o);
        return new ResponseEntity(success, HttpStatus.OK);
    }

}
