package com.lti.myproj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.myproj.model.PersonalDetails;
import com.lti.myproj.model.User;

@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Integer> {
	public PersonalDetails findByCustomerId(int customerId);

	public User findById(int id);
}