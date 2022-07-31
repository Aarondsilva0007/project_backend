package com.lti.myproj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.myproj.model.VehicleDetails;
import com.lti.myproj.model.User;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, Integer> {
	public List<VehicleDetails> findByUser(User user);
}