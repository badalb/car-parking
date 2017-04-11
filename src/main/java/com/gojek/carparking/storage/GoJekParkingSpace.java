package com.gojek.carparking.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.gojek.carparking.domain.Car;

public class GoJekParkingSpace {

	//private static int MAX_DEFAULT_SIZE = 1;

	private static List<Car> availableSlotList;

	public static List<Car> createSlotList(Integer maxSize) {

		if (availableSlotList == null) {
			synchronized (GoJekParkingSpace.class) {
				if (availableSlotList == null) {
					availableSlotList = new ArrayList<Car>(Collections.nCopies(maxSize, null));
				}
			}
		}
		return availableSlotList;
	}

	public static List<Car> getAvailableSlotList() {
//		if (availableSlotList == null) {
//			System.out.println("Initializing..........");
//			return createSlotList(MAX_DEFAULT_SIZE);
//		}
		return availableSlotList;
	}
}
