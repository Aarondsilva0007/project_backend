package com.lti.myproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "LTI_vehicle_details")
public class VehicleDetails {

	public VehicleDetails() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column()
	private int vehicleId;

	@Column(name = "CAR_MAKE")
	private String carMake;

	@Column(name = "CAR_MODEL")
	private String carModel;

	@Column(name = "EX_SHOWROOM_PRICE")
	private int exShowroomPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Customer_id")
	public User user;

	public VehicleDetails(String carMake, String carModel, int exShowroomPrice) {
		super();
		this.carMake = carMake;
		this.carModel = carModel;
		this.exShowroomPrice = exShowroomPrice;

	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setCustomerId(int customerId) {
		this.vehicleId = vehicleId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getExShowroomPrice() {
		return exShowroomPrice;
	}

	public void setExShowroomPrice(int exShowroomPrice) {
		this.exShowroomPrice = exShowroomPrice;
	}

}
