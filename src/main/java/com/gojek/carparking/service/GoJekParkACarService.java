package com.gojek.carparking.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.domain.Car;
import com.gojek.carparking.storage.GoJekParkingSpace;
import com.gojek.carparking.storage.GoJekParkingSearchMap;
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
		GoJekParkingSearchMap.getSlotRegistrationNoMap().put(car.getRegistrationNo(), firstAvaiableSlot);

		List<Integer> parkingLots = GoJekParkingSearchMap.getColorLotMap().get(car.getColor());
		if (parkingLots == null) {
			parkingLots = new ArrayList<>();
		}
		parkingLots.add(firstAvaiableSlot);
		GoJekParkingSearchMap.getColorLotMap().put(car.getColor(), parkingLots);

		GoJekParkingSpace.getAvailableSlotList().set(firstAvaiableSlot, car);
		System.out.println(MessageFormat.format(CommonConstant.PARKING_SPACE_BLOCKED, firstAvaiableSlot + 1,
				car.getRegistrationNo()));
	}

	private Integer getFirstEmptySlot() {
		for (int slot = 0; slot < GoJekParkingSpace.getAvailableSlotList().size(); slot++) {
			if (GoJekParkingSpace.getAvailableSlotList().get(slot) == null) {
				return slot;
			}
		}
		return null;
	}
}
