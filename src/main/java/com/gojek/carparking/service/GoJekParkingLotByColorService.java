package com.gojek.carparking.service;

import com.gojek.carparking.storage.GoJekParkingSearchMap;
import com.gojek.carparking.vo.ParkingParameter;

public class GoJekParkingLotByColorService implements GoJekParkingService {

	@Override
	public void doAction(ParkingParameter param) {
		String color = param.getValue()[1];
		GoJekParkingSearchMap.getColorLotMap().get(color).forEach(value -> {
			System.out.println(value + 1);
		});
	}

}
