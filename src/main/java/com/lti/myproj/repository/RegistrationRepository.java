package com.lti.myproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.myproj.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer> {
	
	public User findByEmailId(String emaiId);
	public User findByEmailIdAndPassword(String emailId, String password);
	public User findById(int id);

}
