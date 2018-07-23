package com.doomra.parkinglots.pojo;

public class InputParkingSlotPojo {
	private int numberOfParkingSlots;
	private String reservationStatus;
	private String vehicleType;
	
	public InputParkingSlotPojo(){}
	
	public int getNumberOfParkingSlots() {
		return numberOfParkingSlots;
	}
	public void setNumberOfParkingSlots(int numberOfParkingSlots) {
		this.numberOfParkingSlots = numberOfParkingSlots;
	}
	public String getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
}
