package com.doomra.parkinglots.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.doomra.parkinglots.enums.ParkingStatus;
import com.doomra.parkinglots.enums.ReservationStatus;
import com.doomra.parkinglots.enums.VehicleType;


@Entity
public class ParkingSlot {
	
	public ParkingSlot(){}
	
	public ParkingSlot(VehicleType vehicleType, Vehicle vehicle, ParkingStatus parkingStatus, ReservationStatus reservationStatus){
		this.vehicleType = vehicleType.toString();
		this.parkingStatus = parkingStatus.toString();
		this.reservationStatus = reservationStatus.toString();
		this.vehicle = vehicle;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String vehicleType;
	@OneToOne
	private Vehicle vehicle;
	private String parkingStatus=ParkingStatus.UNPARKED.toString();
	private String reservationStatus;
	@Transient
	private List<String> errors = new ArrayList<>();
	@Transient
	private List<String> warnings = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public String getParkingStatus() {
		return parkingStatus;
	}
	public void setParkingStatus(String parkingStatus) {
		this.parkingStatus = parkingStatus;
	}
	public String getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public List<String> getWarnings() {
		return warnings;
	}

	public void setWarnings(List<String> warnings) {
		this.warnings = warnings;
	}	

}
