package com.doomra.parkinglots.enums;

import java.util.HashMap;
import java.util.Map;

public enum ParkingStatus {
	PARKED("Parked"),UNPARKED("Unparked");
	private String status;

	ParkingStatus(String status){
		this.status = status;
	}
	
	public String toString(){
		return this.status;
	}
	
	private static Map<String, ParkingStatus> stringEnumMap = new HashMap<>();
	
	static{
		for(ParkingStatus entry: ParkingStatus.values()){
			stringEnumMap.put(entry.toString(), entry);
		}
	}
	
	public ParkingStatus get(String status){
		return stringEnumMap.get(status);
	}
}
