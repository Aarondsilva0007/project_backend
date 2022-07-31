package com.lti.myproj.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.myproj.model.EmploymentDetails;
import com.lti.myproj.model.User;

import com.lti.myproj.repository.EmploymentDetailsRepository;
import com.lti.myproj.repository.RegistrationRepository;

import com.lti.myproj.exception.*;

@Service
@Transactional
public class EmploymentDetailsServiceImpl implements EmploymentDetailsService {
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private EmploymentDetailsRepository employmentDetailsRepo;

	@Autowired
	private RegistrationRepository registrationRepo;

	@Override
	public List<EmploymentDetails> getEmploymentDetails() {
		return employmentDetailsRepo.findAll();
	}

	@Override
	public EmploymentDetails findById(int userId) {
		return employmentDetailsRepo.findByCustomerId(userId);
	}

	@Override
	@Transactional
	public EmploymentDetails addEmploymentDetails(EmploymentDetails employmentDetails, int id)
			throws UserNotFoundException {
		User user = registrationRepo.findById(id);
		// if user not found throw exception
		if (user == null) {
			throw new UserNotFoundException();
		}

		EmploymentDetails existingEmploymentDetails = employmentDetailsRepo.findByCustomerId(id);
		// if details already exist then update and return
		if (existingEmploymentDetails != null) {
			existingEmploymentDetails.update(employmentDetails);
			return existingEmploymentDetails;
		}

		// set user for one to one relationship
		employmentDetails.setUser(user);
		return employmentDetailsRepo.save(employmentDetails);
	}

}
