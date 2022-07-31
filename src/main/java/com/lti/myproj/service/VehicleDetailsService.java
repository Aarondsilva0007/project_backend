package com.lti.myproj.service;

import java.util.List;

import com.lti.myproj.model.VehicleDetails;

public interface VehicleDetailsService {
	public VehicleDetails getVehicleById(int vehicleId);

	public List<VehicleDetails> getVehiclesByUserId(int userId);

	public VehicleDetails addVehicleDetails(VehicleDetails vehicleDetails, int userId);
}
