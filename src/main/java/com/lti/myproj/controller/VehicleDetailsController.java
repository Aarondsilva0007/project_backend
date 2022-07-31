package com.lti.myproj.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.*;

import com.lti.myproj.model.BankDetails;
import com.lti.myproj.model.EmploymentDetails;
import com.lti.myproj.model.IdentityDetails;
import com.lti.myproj.model.PersonalDetails;
import com.lti.myproj.model.User;
import com.lti.myproj.model.VehicleDetails;

import com.lti.myproj.service.RegistrationService;
import com.lti.myproj.service.*;

// exceptions
import com.lti.myproj.exception.UserNotFoundException;

@RestController
@RequestMapping(value = "/api/vehicle")
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleDetailsController {

    @Autowired
    private VehicleDetailsServiceImpl vehicleDetailsService;

    @GetMapping()
    public ResponseEntity<String> vehicleRequestWithoutId() {
        return new ResponseEntity<String>("Invalid request", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getVehicleById(@PathVariable(value = "id") int userId) {
        try {
            List<VehicleDetails> vehicles = vehicleDetailsService.getVehiclesByUserId(userId);
            return new ResponseEntity<List<VehicleDetails>>(vehicles, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> addVehicleDetails(@PathVariable(value = "id") int userId,
            @RequestBody VehicleDetails vehicleDetails) {
        try {
            VehicleDetails newVehicle = vehicleDetailsService.addVehicleDetails(vehicleDetails, userId);
            return new ResponseEntity<VehicleDetails>(newVehicle, HttpStatus.CREATED);
        } catch (UserNotFoundException userNotFoundException) {
            return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}