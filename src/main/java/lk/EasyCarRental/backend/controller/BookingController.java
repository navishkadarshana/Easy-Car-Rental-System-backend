package lk.EasyCarRental.backend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lk.EasyCarRental.backend.Service.BankSlipService;
import lk.EasyCarRental.backend.Service.BookingService;
import lk.EasyCarRental.backend.dto.*;
import lk.EasyCarRental.backend.entity.Booking;
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
@RequestMapping("/api/v1/booking")
@CrossOrigin
public class BookingController {

    private static final String UPLOADED_FOLDER = "/home/navi/Project Files/IntellijIDEA Project/Car Rental System/Car Rental System Fronend/DashbroadFrontEnd/assests/Image/bankSlipImage/";


    @Autowired
    BookingService bookingService;

    @Autowired
    BankSlipService bankSlipService;


    @PostMapping(path = "/{upload}")
    public ResponseEntity upload(@RequestParam("file") MultipartFile[] file, @RequestParam("id") String id) throws JsonProcessingException {

        ObjectMapper mapper =new ObjectMapper();

        BookingDTO bookingDTO =mapper.readValue(id,BookingDTO.class);

        for (MultipartFile files : file) {

            String fileNames = UUID.randomUUID().toString();
            String contentType = files.getContentType();
            String[] split = contentType.split("/");

            File destinationFile = new File(UPLOADED_FOLDER + fileNames + "." + split[1]);

            try {

                files.transferTo(destinationFile);

                BankSlipDTO bankSlip = new BankSlipDTO("assests/Image/bankSlipImage/"+fileNames+"."+split[1],bookingDTO.getCusId());
                bookingService.saveBooking(bookingDTO,bankSlip);



            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/getAllPendingRequest")
    public ResponseEntity getAllPendingRequest(){

        List<Object> allPendingBooking = bookingService.getAllPendingBooking();
        StandradResponse success = new StandradResponse(200, "success", allPendingBooking);
        return new ResponseEntity(success, HttpStatus.OK);
    }


}



