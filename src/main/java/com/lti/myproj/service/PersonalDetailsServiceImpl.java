package com.lti.myproj.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.myproj.model.PersonalDetails;
import com.lti.myproj.model.User;
import com.lti.myproj.repository.PersonalDetailsRepository;
import com.lti.myproj.repository.RegistrationRepository;

// exceptions
import com.lti.myproj.exception.UserNotFoundException;

@Service
@Transactional
public class PersonalDetailsServiceImpl implements PersonalDetailsService {
	@PersistenceContext
	private EntityManager em;
	private final PersonalDetailsRepository personalDetailsRepo;
	private final RegistrationRepository registrationRepo;

	@Autowired
	public PersonalDetailsServiceImpl(PersonalDetailsRepository personalDetailsRepo,
			RegistrationRepository registrationRepo) {
		this.personalDetailsRepo = personalDetailsRepo;
		this.registrationRepo = registrationRepo;
	}

	@Override
	public List<PersonalDetails> getPersonalDetails() {
		// admin method
		return personalDetailsRepo.findAll();
	}

	@Override
	public PersonalDetails getPersonalDetailsById(int userId) {
		return personalDetailsRepo.findByCustomerId(userId);
	}

	@Override
	@Transactional
	public PersonalDetails addPersonalDetails(PersonalDetails personalDetails, int id) throws UserNotFoundException {
		User user = registrationRepo.findById(id);
		// if user not found throw exception
		if (user == null) {
			throw new UserNotFoundException();
		}

		PersonalDetails existingPersonalDetails = personalDetailsRepo.findByCustomerId(id);
		// if details already exist then update and return
		if (existingPersonalDetails != null) {
			existingPersonalDetails.update(personalDetails);

			return existingPersonalDetails;
		}

		// set user for one to one relationship
		personalDetails.setUser(user);
		return personalDetailsRepo.save(personalDetails);
	}
}
