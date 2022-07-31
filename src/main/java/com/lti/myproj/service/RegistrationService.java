package com.lti.myproj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.myproj.model.User;
import com.lti.myproj.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}

	public User fetchUserByEmailIdAndPassword(String email, String password) {
		return repo.findByEmailIdAndPassword(email, password);

	}

	public User fetchUserById(int id) {
		return repo.findById(id);
	}
}
