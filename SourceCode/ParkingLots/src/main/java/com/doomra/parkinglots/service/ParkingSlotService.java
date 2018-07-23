package com.doomra.parkinglots.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doomra.parkinglots.entities.ParkingSlot;
import com.doomra.parkinglots.entities.Vehicle;
import com.doomra.parkinglots.enums.ParkingStatus;
import com.doomra.parkinglots.enums.ReservationStatus;
import com.doomra.parkinglots.enums.VehicleType;
import com.doomra.parkinglots.jparepository.EmployeeJpaRepository;
import com.doomra.parkinglots.jparepository.ParkingSlotJpaRepository;
import com.doomra.parkinglots.jparepository.VehicleJpaRepository;

@Service
public class ParkingSlotService {
	
	@Autowired
	private ParkingSlotJpaRepository parkingSlotRepository;

	@Autowired
	private VehicleJpaRepository vehicleRepository;
	
	@Autowired
	private EmployeeJpaRepository empRepository;
	
	public List<ParkingSlot> getAllParkingSlots(){
		return parkingSlotRepository.findAll();
	}
	
	public ParkingSlot getParkingSlotById(int parkingSlotId){
		return parkingSlotRepository.findById(parkingSlotId).get();
	}
	
	public ParkingSlot getParkingSlotByVehicleNumber(String vehicleNumber){
		return parkingSlotRepository.findByVehicleVehicleNumber(vehicleNumber);
	}
	
	public ParkingSlot getParkingSlotByVehicleEmployeeId(long employeeId){
		return parkingSlotRepository.findByVehicleEmployeeEmployeeId(employeeId);
	}
	
	public List<ParkingSlot> getParkingSlotByReservationStatus(ReservationStatus reservationStatus){
		return parkingSlotRepository.findByReservationStatus(reservationStatus.toString());
	}
	
	public List<ParkingSlot> getParkingSlotByParkingStatus(ParkingStatus parkingStatus){
		return parkingSlotRepository.findByParkingStatus(parkingStatus.toString());
	}
	
	public List<ParkingSlot> getParkingSlotByVehicleType(VehicleType vehicleType){
		return parkingSlotRepository.findByVehicleType(vehicleType.toString());
	}
	
	public List<ParkingSlot> getParkingSlotByParkingStatusAndVehicleType(ParkingStatus parkingStatus, VehicleType vehicleType){
		return parkingSlotRepository.findByParkingStatusAndVehicleType(parkingStatus.toString(), vehicleType.toString());
	}
	
	public List<ParkingSlot> getParkingSlotByReservationStatusAndVehicleType(ReservationStatus reservationStatus, VehicleType vehicleType){
		return parkingSlotRepository.findByReservationStatusAndVehicleType(reservationStatus.toString(), vehicleType.toString());
	}
	
	public void addParkingSlot(ParkingSlot parkingSlot){
		parkingSlotRepository.save(parkingSlot);
	}
	public void createMultipleParkingSlots(int numberOfParkingSlots, ReservationStatus reservationStatus, VehicleType vehicleType){
		List<ParkingSlot> parkingSlots = new ArrayList<>();
		for(int i=0;i<numberOfParkingSlots;i++){
			ParkingSlot parkingSlot = new ParkingSlot();
			parkingSlot.setParkingStatus(ParkingStatus.UNPARKED.toString());
			parkingSlot.setReservationStatus(reservationStatus.toString());
			parkingSlot.setVehicleType(vehicleType.toString());
			parkingSlots.add(parkingSlot);
		}
		parkingSlotRepository.saveAll(parkingSlots);
	}
	
	public void updateParkingSlot(ParkingSlot parkingSlot){
		parkingSlotRepository.save(parkingSlot);
	}
	
	public void deleteParkingSlot(int parkingSlotId){
		parkingSlotRepository.deleteById(parkingSlotId);
	}
	
	public void deleteParkingSlotByReservationStatus(ReservationStatus reservationStatus){
		List<ParkingSlot> parkingSlots = parkingSlotRepository.findByReservationStatus(reservationStatus.toString());
		parkingSlotRepository.deleteInBatch(parkingSlots);
	}
	
	public void parkVehicle(String vehicleNumber, int slotId){
		Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
		ParkingSlot parkingSlot = getParkingSlotById(slotId);
		if(vehicle!=null && parkingSlot!=null){
			parkingSlot.setVehicle(vehicle);
			parkingSlot.setParkingStatus(ParkingStatus.PARKED.toString());
			parkingSlotRepository.save(parkingSlot);			 
		}else{
			System.out.println(String.format("ERROR: Either Vehicle with %s vehiclenumber is not present or parking slot with $d slotId is not present", vehicleNumber, slotId));
		}
	}
	
	public void unParkVehicle(String vehicleNumber){
		ParkingSlot parkingSlot = parkingSlotRepository.findByVehicleVehicleNumber(vehicleNumber);
		if(parkingSlot!=null){
			parkingSlot.setVehicle(null);
			parkingSlot.setParkingStatus(ParkingStatus.UNPARKED.toString());
			parkingSlotRepository.save(parkingSlot);
		}else{
			System.out.println(String.format("ERROR: Unable to fetch the parkingslot for Vehicle with %s vehiclenumber", vehicleNumber));
		}
	}

}
