package com.gojek.carparking.storage;

import java.util.HashMap;
import java.util.Map;

import com.gojek.carparking.domain.Car;

public class GoJekParkingLot {

	private static Map<Integer, Car> slotCarMap;

	public static Map<Integer, Car> getSlotCarMap() {

		if (slotCarMap == null) {
			synchronized (GoJekParkingAvailablity.class) {
				if (slotCarMap == null) {
					slotCarMap = new HashMap<Integer, Car>();
				}
			}
		}

		return slotCarMap;
	}
}
