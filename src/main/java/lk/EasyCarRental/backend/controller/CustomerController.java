package lk.EasyCarRental.backend.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lk.EasyCarRental.backend.Service.BankSlipService;
import lk.EasyCarRental.backend.Service.CustomerService;
import lk.EasyCarRental.backend.Service.NicImageService;
import lk.EasyCarRental.backend.dto.BankSlipDTO;
import lk.EasyCarRental.backend.dto.CustomerDTO;
import lk.EasyCarRental.backend.dto.NicImageDTO;
import lk.EasyCarRental.backend.dto.UserDTO;
import lk.EasyCarRental.backend.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    private static final String UPLOADED_FOLDER = "/home/navi/Project Files/IntellijIDEA Project/Car Rental System/Car Rental System Fronend/DashbroadFrontEnd/assests/Image/CustomerNicImage/";

    @Autowired
    BankSlipService bankSlipService;

    @Autowired
    CustomerService customerService;

    @Autowired
    NicImageService nicImageService;



    /*@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto){

        customerService.saveCustomer(dto);
        StandradResponse success = new StandradResponse(200, "success", null);
        return new ResponseEntity(success, HttpStatus.OK);

    }*/




    @PostMapping(path = "/login",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity LoginCustomer(@RequestBody UserDTO dto){

        customerService.Login(dto);
        StandradResponse success = new StandradResponse(200, "success", null);
        return new ResponseEntity(success, HttpStatus.OK);

    }


    @GetMapping(path = "/{id}")
    public ResponseEntity searchCustomer(@PathVariable String id){

        CustomerDTO customer = customerService.searchCustomer(id);
        StandradResponse success = new StandradResponse(200, "success", customer);
        return new ResponseEntity(success, HttpStatus.OK);
    }



    @PostMapping(path = "/{upload}")
    public ResponseEntity upload(@RequestParam("file") MultipartFile[] file, @RequestParam("id") String id) throws JsonProcessingException {

        ObjectMapper mapper =new ObjectMapper();

        CustomerDTO customerDTO=mapper.readValue(id,CustomerDTO.class);

        for (MultipartFile files : file) {

            String fileNames = UUID.randomUUID().toString();
            String contentType = files.getContentType();
            String[] split = contentType.split("/");

            File destinationFile = new File(UPLOADED_FOLDER + fileNames + "." + split[1]);

            try {

                files.transferTo(destinationFile);

                NicImageDTO nicImage = new NicImageDTO(UUID.randomUUID().toString(), "assests/Image/CustomerNicImage/"+fileNames+"."+split[1],customerDTO.getNic());
                customerService.saveCustomer(customerDTO);
                nicImageService.saveReturnCar(nicImage);


            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }



}



