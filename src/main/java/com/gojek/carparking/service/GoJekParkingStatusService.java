package com.gojek.carparking.service;

import java.util.stream.IntStream;

import com.gojek.carparking.domain.Car;
import com.gojek.carparking.storage.GoJekParkingSearchMap;
import com.gojek.carparking.storage.GoJekParkingSpace;
import com.gojek.carparking.vo.ParkingParameter;

public class GoJekParkingStatusService implements GoJekParkingService {

	@Override
	public void doAction(ParkingParameter param) {
		if (GoJekParkingSearchMap.getSlotRegistrationNoMap().isEmpty()) {
			System.out.println("Parking lot is empty");
			return;
		}

		System.out.println("Lot No" + "    " + "Registration No" + "    " + "Color");

		IntStream.range(0, GoJekParkingSpace.getAvailableSlotList().size()).forEach(i -> {
			Car car = GoJekParkingSpace.getAvailableSlotList().get(i);
			if (car != null) {
				int j = i + 1;
				System.out.println("   " + j + "    " + car.getRegistrationNo() + "    " + car.getColor());
			}
		});
	}

}
