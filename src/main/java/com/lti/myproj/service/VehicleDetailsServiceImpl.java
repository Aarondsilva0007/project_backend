package com.lti.myproj.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.RequiredArgsConstructor;
import lombok.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.myproj.model.*;
import com.lti.myproj.repository.*;
import com.lti.myproj.exception.UserNotFoundException;

@Service
@Transactional
public class VehicleDetailsServiceImpl implements VehicleDetailsService {
	@PersistenceContext
	private EntityManager em;
	private final VehicleDetailsRepository vehicleDetailsRepo;
	private final RegistrationRepository registrationRepo;

	@Autowired
	public VehicleDetailsServiceImpl(VehicleDetailsRepository vehicleDetailsRepo,
			RegistrationRepository registrationRepo) {
		this.vehicleDetailsRepo = vehicleDetailsRepo;
		this.registrationRepo = registrationRepo;
	}

	@Override
	public VehicleDetails getVehicleById(int vehicleId) {
		return null;
	}

	@Override
	public List<VehicleDetails> getVehiclesByUserId(int userId) throws UserNotFoundException {
		User user = registrationRepo.findById(userId);
		if (user == null) {
			throw new UserNotFoundException();
		}

		return vehicleDetailsRepo.findByUser(user);
	}

	@Override
	public VehicleDetails addVehicleDetails(VehicleDetails vehicledetails, int userId) throws UserNotFoundException {
		User user = registrationRepo.findById(userId);
		if (user == null) {
			throw new UserNotFoundException();
		}
		vehicledetails.setUser(user);
		return vehicleDetailsRepo.save(vehicledetails);
	}

}
