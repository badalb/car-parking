package com.gojek.carparking.service;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.storage.GoJekParkingSearchMap;
import com.gojek.carparking.vo.ParkingParameter;

public class GoJekParkingLotByRegistrationNoService implements GoJekParkingService {

	@Override
	public void doAction(ParkingParameter param) {

		String registrationNo = param.getValue()[1];
		Integer result = GoJekParkingSearchMap.getSlotRegistrationNoMap().get(registrationNo);

		if (result == null) {
			System.out.println(CommonConstant.NOT_FOUND);
		} else {
			System.out.println(result+1);
		}

	}

}
