package com.doomra.parkinglots.enums;

import java.util.HashMap;
import java.util.Map;

public enum ReservationStatus {
	EXECUTIVE("Executive"),UNRESERVED("Unreserved");
	private String status;
	ReservationStatus(String status){
		this.status = status;
	}
	
	public String toString(){
		return this.status;
	}
	
	
	private static Map<String, ReservationStatus> stringEnumMap = new HashMap<>();
	
	static{
		for(ReservationStatus resEnumEntry: ReservationStatus.values()){
			stringEnumMap.put(resEnumEntry.toString(), resEnumEntry);
		}
	}
	
	public static ReservationStatus get(String status){
		return stringEnumMap.get(status);
	}

}
