package com.gojek.carparking.service;

import com.gojek.carparking.storage.GoJekParkingLot;
import com.gojek.carparking.vo.ParkingParameter;

public class GoJekParkingStatusService implements GoJekParkingService {

	@Override
	public void doAction(ParkingParameter param) {
		if (GoJekParkingLot.getSlotCarMap().isEmpty()) {
			System.out.println("Parking lot is empty");
			return;
		}

		System.out.println("Lot No" + "    " + "Registration No" + "    " + "Color");
		GoJekParkingLot.getSlotCarMap().forEach((key, value) -> {
			System.out.println("   " + key + 1 + "    " + value.getRegistrationNo() + "    " + value.getColor());
		});
	}

}
