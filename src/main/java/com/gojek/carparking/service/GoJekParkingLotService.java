package com.gojek.carparking.service;

import java.text.MessageFormat;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.storage.GoJekParkingSearchMap;
import com.gojek.carparking.storage.GoJekParkingSpace;
import com.gojek.carparking.vo.ParkingParameter;

public class GoJekParkingLotService implements GoJekParkingService {

	@Override
	public void doAction(ParkingParameter param) throws NumberFormatException {
		try {

			Integer capacity = Integer.valueOf((String) param.getValue()[1]);
			GoJekParkingSpace.createSlotList(capacity);
			GoJekParkingSearchMap.initializeSearchMap();
			System.out.println(MessageFormat.format(CommonConstant.PARKING_LOT_CREATED, capacity));

		} catch (NumberFormatException e) {
			System.out.println(CommonConstant.ERROR_PARKING_LOT);
		}

	}

}
