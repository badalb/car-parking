package com.gojek.carparking.service;

import com.gojek.carparking.storage.GoJekParkingSearchMap;
import com.gojek.carparking.storage.GoJekParkingSpace;
import com.gojek.carparking.vo.ParkingParameter;

public class GoJekRegistrationNoByColorService implements GoJekParkingService {

	@Override
	public void doAction(ParkingParameter param) {
		String color = param.getValue()[1];

		GoJekParkingSearchMap.getColorLotMap().get(color).forEach(slot -> {
			System.out.println(GoJekParkingSpace.getAvailableSlotList().get(slot).getRegistrationNo());
		});
	}

}
