package com.doomra.parkinglots.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doomra.parkinglots.entities.ParkingSlot;

public interface ParkingSlotJpaRepository extends JpaRepository<ParkingSlot, Integer> {
	
	public ParkingSlot findByVehicleVehicleNumber(String vehicleNumber);
	
	public ParkingSlot findByVehicleEmployeeEmployeeId(long employeeId);
	
	public List<ParkingSlot> findByReservationStatus(String reservationStatus);
	
	public List<ParkingSlot> findByVehicleType(String vehicleType);
	
	public List<ParkingSlot> findByParkingStatus(String parkingStatus);
	
	public List<ParkingSlot> findByReservationStatusAndVehicleType(String reservationStatus,String vehicleType);
	
	public List<ParkingSlot> findByParkingStatusAndVehicleType(String parkingStatus,String vehicleType);

}
