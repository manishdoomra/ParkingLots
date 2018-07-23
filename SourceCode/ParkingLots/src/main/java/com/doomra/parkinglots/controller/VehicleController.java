package com.doomra.parkinglots.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doomra.parkinglots.entities.Vehicle;
import com.doomra.parkinglots.service.VehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping("/vehicles")
	public List<Vehicle> getAllVehicles(){
		return vehicleService.getAllVehicles();
	}
	
	@RequestMapping("/vehicles/{vehicleNumber}")
	public Vehicle getVehicleByVehicleNumber(@PathVariable String vehicleNumber){
		return vehicleService.getVehicleByVehicleNumber(vehicleNumber);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/vehicles")
	public void addVehicle(@RequestBody Vehicle vehicle){
		vehicleService.addVehicle(vehicle);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/vehicles")
	public void updateVehicle(@RequestBody Vehicle vehicle){
		vehicleService.addVehicle(vehicle);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/vehicles/{vehicleNumber}")
	public void deleteVehicle(@PathVariable String vehicleNumber){
		vehicleService.deleteVehicleByVehicleNumber(vehicleNumber);
	}

}
