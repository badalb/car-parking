package com.gojek.carparking.service;

import java.util.ArrayList;
import java.util.List;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.storage.GoJekParkingLot;
import com.gojek.carparking.vo.ParkingParameter;

public class GoJekParkingLotByRegistrationNoService implements GoJekParkingService {

	@Override
	public void doAction(ParkingParameter param) {

		String registrationNo = param.getValue()[1];
		List<Integer> result = new ArrayList<>();

		GoJekParkingLot.getSlotCarMap().forEach((key, value) -> {
			if (value.getRegistrationNo().equalsIgnoreCase(registrationNo)) {
				result.add(key + 1);
			}
		});

		if (result.isEmpty()) {
			System.out.println(CommonConstant.NOT_FOUND);
		} else {
			System.out.println(result.get(0));
		}

	}

}
