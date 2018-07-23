package com.doomra.parkinglots.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doomra.parkinglots.entities.Vehicle;
import com.doomra.parkinglots.jparepository.VehicleJpaRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleJpaRepository vehicleRepository;
	
	public List<Vehicle> getAllVehicles(){
		return vehicleRepository.findAll();
	}
	
	public Vehicle getVehiclesById(int vehicleId){
		return vehicleRepository.findById(vehicleId).get();
	}
	
	public List<Vehicle> getVehiclesByEmployeeId(long employeeId){
		return vehicleRepository.findByEmployeeEmployeeId(employeeId);
	}
	
	public Vehicle getVehicleByVehicleNumber(String vehicleNumber){
		return vehicleRepository.findByVehicleNumber(vehicleNumber);
	}
	
	public void addVehicle(Vehicle vehicle){
		vehicleRepository.save(vehicle);
	}
	
	public void updateVehicle(Vehicle vehicle){
		vehicleRepository.save(vehicle);
	}
	
	public void deleteVehicle(int vehicleId){
		vehicleRepository.deleteById(vehicleId);
	}
	
	public void deleteVehicleByVehicleNumber(String vehicleNumber){
		Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
		vehicleRepository.delete(vehicle);
	}

}
