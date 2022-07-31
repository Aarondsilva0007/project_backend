package com.lti.myproj.service;

import java.util.List;

import com.lti.myproj.model.PersonalDetails;

// exceptions
import com.lti.myproj.exception.UserNotFoundException;

public interface PersonalDetailsService {
	public PersonalDetails getPersonalDetailsById(int userId);

	public List<PersonalDetails> getPersonalDetails();

	public PersonalDetails addPersonalDetails(PersonalDetails personalDetails, int id) throws UserNotFoundException;
}
