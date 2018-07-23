package com.doomra.parkinglots.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doomra.parkinglots.entities.Vehicle;

public interface VehicleJpaRepository extends JpaRepository<Vehicle, Integer>{
	
	public List<Vehicle> findByEmployeeEmployeeId(long employeeId);
	
	public Vehicle findByVehicleNumber(String vehicleNumber);

}
