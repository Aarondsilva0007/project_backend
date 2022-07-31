package com.lti.myproj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.lti.myproj.service.*;

// models
import com.lti.myproj.model.FileUpload;
import com.lti.myproj.model.User;

// exceptions
import com.lti.myproj.exception.UserNotFoundException;
import com.lti.myproj.message.ResponseMessage;

@RestController
@RequestMapping(value = "/api/documents")
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private FileHandlerService fileHandlerService;

    @Autowired
    private DocumentServiceImpl documentService;

    @PostMapping("/{id}")
    public ResponseEntity<?> uploadFile(@PathVariable(value = "id") int userId, FileUpload fileUpload) {
        User user = registrationService.fetchUserById(userId);
        if (user != null) {
            try {
                documentService.addDocuments(
                        fileHandlerService.uploadUsersDocuments(fileUpload, user), userId);
                return new ResponseEntity<String>("Files uploaded successfully", HttpStatus.ACCEPTED);
            } catch (Exception e) {
                System.out.println(e);
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                        .body(new ResponseMessage("Fail to upload files!"));
            }
        }

        return new ResponseEntity<String>("No user with id exists", HttpStatus.BAD_REQUEST);
    }

}