package com.doomra.parkinglots.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doomra.parkinglots.entities.ParkingSlot;
import com.doomra.parkinglots.enums.ReservationStatus;
import com.doomra.parkinglots.enums.VehicleType;
import com.doomra.parkinglots.pojo.InputParkingSlotPojo;
import com.doomra.parkinglots.pojo.ParkVehiclePojo;
import com.doomra.parkinglots.service.ParkingSlotService;

@RestController
public class ParkingSlotController {
	
	@Autowired
	private ParkingSlotService parkingSlotService;
	
	@RequestMapping("/parkingslots")
	public List<ParkingSlot> getAllParkingSlots(){
		return parkingSlotService.getAllParkingSlots();
	}
	
	@RequestMapping("/parkingslots/unreserved")
	public List<ParkingSlot> getAllUnreservedParkingSlots(){
		return parkingSlotService.getParkingSlotByReservationStatus(ReservationStatus.UNRESERVED);
	}
	
	@RequestMapping("/parkingslots/executive")
	public List<ParkingSlot> getAllExecutiveParkingSlots(){
		return parkingSlotService.getParkingSlotByReservationStatus(ReservationStatus.EXECUTIVE);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/parkingslots")
	public void createMultipleParkingSlots(@RequestBody InputParkingSlotPojo pojo){
		parkingSlotService.createMultipleParkingSlots(pojo.getNumberOfParkingSlots(), ReservationStatus.get(pojo.getReservationStatus()), VehicleType.get(pojo.getVehicleType()));
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/parkingslots/park")
	public void parkVehicle(@RequestBody ParkVehiclePojo pojo){
		parkingSlotService.parkVehicle(pojo.getVehicleNumber(), pojo.getSlotId());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/parkingslots/unpark")
	public void unParkVehicle(@RequestBody ParkVehiclePojo pojo){
		parkingSlotService.unParkVehicle(pojo.getVehicleNumber());
	}

}
