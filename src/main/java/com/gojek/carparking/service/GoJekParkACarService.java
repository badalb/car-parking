package com.gojek.carparking.service;

import java.text.MessageFormat;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.domain.Car;
import com.gojek.carparking.storage.GoJekParkingAvailablity;
import com.gojek.carparking.storage.GoJekParkingLot;
import com.gojek.carparking.vo.ParkingParameter;

public class GoJekParkACarService implements GoJekParkingService {

	@Override
	public void doAction(ParkingParameter param) {
		Integer firstAvaiableSlot = getFirstEmptySlot();

		if (firstAvaiableSlot == null) {
			System.out.println(CommonConstant.PARKING_FULL);
			return;
		}

		Car car = new Car(param.getValue()[1], param.getValue()[2]);
		GoJekParkingLot.getSlotCarMap().put(firstAvaiableSlot, car);
		GoJekParkingAvailablity.getAvailableSlotList().set(firstAvaiableSlot, Integer.valueOf(1));
		System.out.println(MessageFormat.format(CommonConstant.PARKING_SPACE_BLOCKED, firstAvaiableSlot + 1,
				car.getRegistrationNo()));
	}

	private Integer getFirstEmptySlot() {
		for (int slot = 0; slot < GoJekParkingAvailablity.getAvailableSlotList().size(); slot++) {
			if (GoJekParkingAvailablity.getAvailableSlotList().get(slot) == 0) {
				return slot;
			}
		}
		return null;
	}
}
