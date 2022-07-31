package com.lti.myproj.controller;

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

// service
import com.lti.myproj.service.EmploymentDetailsServiceImpl;

// models
import com.lti.myproj.model.EmploymentDetails;

// message
import com.lti.myproj.message.ResponseMessage;

// exceptions
import com.lti.myproj.exception.UserNotFoundException;
import com.lti.myproj.message.ResponseMessage;

@RestController
@RequestMapping(value = "/api/employment-details")
@CrossOrigin(origins = "http://localhost:4200")
public class EmploymentDetailsController {

    @Autowired
    private EmploymentDetailsServiceImpl employmentDetailsService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getEmploymentDetails(@PathVariable(name = "id") int userId) {
        EmploymentDetails employmentDetails = employmentDetailsService.findById(userId);
        if (employmentDetails != null) {
            return new ResponseEntity<EmploymentDetails>(
                    employmentDetails,
                    HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<ResponseMessage>(
                new ResponseMessage("No employee details found"),
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> postEmploymentDetails(
            @PathVariable(name = "id") int userId,
            @RequestBody EmploymentDetails employmentDetails) {

        try {

            this.employmentDetailsService
                    .addEmploymentDetails(employmentDetails, userId);

            return new ResponseEntity<ResponseMessage>(
                    new ResponseMessage("Employment details added Successfully"),
                    HttpStatus.CREATED);
        } catch (UserNotFoundException userNotFoundException) {
            return new ResponseEntity<ResponseMessage>(
                    new ResponseMessage("No User with id found"),
                    HttpStatus.BAD_REQUEST);
        }
        // return new ResponseEntity<ResponseMessage>(
        // new ResponseMessage("Unexpected Error"),
        // HttpStatus.INTERNAL_SERVER_ERROR);

    }
}