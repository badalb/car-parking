package com.gojek.carparking.util;

import java.util.ArrayList;
import java.util.List;

import com.gojek.carparking.domain.Car;
import com.gojek.carparking.storage.GoJekParkingSearchMap;

public class GoJekSearchMapUpdateUtil {

	public static void addCarToParkingLot(Car car, Integer firstAvaiableSlot){
		GoJekParkingSearchMap.getSlotRegistrationNoMap().put(car.getRegistrationNo(), firstAvaiableSlot);

		List<Integer> parkingLots = GoJekParkingSearchMap.getColorLotMap().get(car.getColor());
		if (parkingLots == null) {
			parkingLots = new ArrayList<>();
		}
		parkingLots.add(firstAvaiableSlot);
		GoJekParkingSearchMap.getColorLotMap().put(car.getColor(), parkingLots);
	}
	
	public static void leaveCarFromParkingLot(Car car, Integer slot){
		
		GoJekParkingSearchMap.getSlotRegistrationNoMap().remove(car.getRegistrationNo());
		GoJekParkingSearchMap.getColorLotMap().get(car.getColor()).remove(slot);
	}
}
