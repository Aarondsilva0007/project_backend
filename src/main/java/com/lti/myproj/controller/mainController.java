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
import com.lti.myproj.message.ResponseMessage;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class mainController {

	@Autowired
	private RegistrationService rservice;

	@Autowired
	private PersonalDetailsServiceImpl personalDetailsService;

	@PostMapping("/registeruser")
	public ResponseEntity<?> registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		int tempId = user.getId();
		if ((tempEmailId != null && !"".equals(tempEmailId))) {
			User userobj = rservice.fetchUserByEmailId(tempEmailId);
			if (userobj != null)
				return new ResponseEntity<ResponseMessage>(
						new ResponseMessage("User with this " + tempEmailId + " already exists"),
						HttpStatus.BAD_REQUEST);

		}

		// if (tempId != '\0') {
		// User u = rservice.fetchUserById(tempId);
		// if (u != null)
		// return new ResponseEntity<ResponseMessage>(
		// new ResponseMessage("User with this " + tempId + "already exists"),
		// HttpStatus.BAD_REQUEST);
		// }

		User newUser = rservice.saveUser(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		User userObj = null;
		if (tempEmailId != null && tempPass != null) {
			userObj = rservice.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if (userObj == null) {
			throw new Exception("bad credentials");
		}
		return userObj;
	}

	// @PostMapping("/vehicle/{id}")
	// @ResponseBody
	// public ResponseEntity addVehicleDetails(@PathVariable(value = "id") int
	// userId, @RequestBody VehicleDetails vehicleDetails) {
	// return new ResponseEntity<String>("Something went wrong",
	// HttpStatus.INTERNAL_SERVER_ERROR);
	// }

	@RequestMapping("/details")
	public String userDetails() {
		return "User Id not present - /api/details/{id}";
	}

	@PostMapping("/details/{id}")
	@ResponseBody
	public ResponseEntity addPersonalDetails(@PathVariable(value = "id") int userId,
			@RequestBody PersonalDetails personalDetails)
			throws Exception {
		try {
			PersonalDetails newPersonalDetails = personalDetailsService.addPersonalDetails(personalDetails, userId);
			return new ResponseEntity<PersonalDetails>(newPersonalDetails, HttpStatus.CREATED);
		} catch (UserNotFoundException userNotFoundException) {
			return new ResponseEntity<String>(userNotFoundException.message, HttpStatus.BAD_REQUEST);
		}
	}

	// @PostMapping("/addemploymentdetails")
	// public boolean addEmploymentDetails(@RequestBody EmploymentDetails
	// employmentDetails)
	// {
	// return employmentDetailsService.addEmploymentDetails(employmentDetails);
	//
	// }
	//
	// @GetMapping("/employmentdetails")
	// public List<EmploymentDetails> getAllEmploymentDetails()
	// {
	// return employmentDetailsService.getEmploymentDetails();
	//
	// }
}