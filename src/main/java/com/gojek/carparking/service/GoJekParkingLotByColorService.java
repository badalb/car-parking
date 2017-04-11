package com.gojek.carparking.service;

import com.gojek.carparking.storage.GoJekParkingLot;
import com.gojek.carparking.vo.ParkingParameter;

public class GoJekParkingLotByColorService implements GoJekParkingService {

	@Override
	public void doAction(ParkingParameter param) {
		String color = param.getValue()[1];

		GoJekParkingLot.getSlotCarMap().forEach((key, value) -> {

			if (value.getColor().equalsIgnoreCase(color)) {
				System.out.println(key + 1);
			}
		});
	}

}
