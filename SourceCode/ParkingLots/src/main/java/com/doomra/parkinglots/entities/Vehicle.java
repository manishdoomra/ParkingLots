package com.doomra.parkinglots.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.doomra.parkinglots.enums.VehicleType;

@Entity
public class Vehicle {
	
	public Vehicle(){}
	
	public Vehicle(String vehicleNumber, VehicleType vehicleType, Employee employee){
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType.toString();
		this.employee = employee;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String vehicleNumber;
	private String vehicleType;
	
	@ManyToOne
	private Employee employee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
