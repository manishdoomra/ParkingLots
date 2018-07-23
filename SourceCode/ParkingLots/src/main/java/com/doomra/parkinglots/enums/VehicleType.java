package com.doomra.parkinglots.enums;

import java.util.HashMap;
import java.util.Map;

public enum VehicleType {
	FOUR_WHEELER("FourWheeler"),TWO_WHEELER("TwoWheeler");
	
	private String vehicleType;
	
	VehicleType(String type){
		this.vehicleType=type;
	}
	
	public String toString(){
		return this.vehicleType;
	}
	
	private static Map<String, VehicleType> stringEnumMap = new HashMap<>();
	
	static{
		for(VehicleType entry : VehicleType.values()){
			stringEnumMap.put(entry.toString(), entry);
		}
	}
	
	public static VehicleType get(String type){
		return stringEnumMap.get(type);
	}

}
