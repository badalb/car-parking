package com.gojek.carparking.service;

import java.text.MessageFormat;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.domain.Car;
import com.gojek.carparking.storage.GoJekParkingAvailablity;
import com.gojek.carparking.storage.GoJekParkingLot;
import com.gojek.carparking.vo.ParkingParameter;

public class GoJekLeaveParkingService implements GoJekParkingService {

	@Override
	public void doAction(ParkingParameter param) {

		try {
			Integer slot = Integer.parseInt(param.getValue()[1]);
			Car car = GoJekParkingLot.getSlotCarMap().get(slot - 1);
			if (car == null) {
				System.out.println(CommonConstant.NOT_FOUND);
				return;
			}

			GoJekParkingLot.getSlotCarMap().remove(slot - 1);
			GoJekParkingAvailablity.getAvailableSlotList().set(slot - 1, Integer.valueOf(0));
			System.out.println(MessageFormat.format(CommonConstant.SLOT_FREE, slot));

		} catch (NumberFormatException ex) {
			System.out.println(CommonConstant.ERROR_INVALID_SPACE_NO);
			return;
		}

	}

}
