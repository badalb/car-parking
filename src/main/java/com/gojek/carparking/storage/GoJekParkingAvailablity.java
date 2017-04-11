package com.gojek.carparking.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoJekParkingAvailablity {

	private static int MAX_DEFAULT_SIZE = 1;

	private static List<Integer> availableSlotList;

	public static List<Integer> createSlotList(Integer maxSize) {

		if (availableSlotList == null) {
			synchronized (GoJekParkingAvailablity.class) {
				if (availableSlotList == null) {
					availableSlotList = new ArrayList<Integer>(Collections.nCopies(maxSize, 0));
				}
			}
		}
		return availableSlotList;
	}

	public static List<Integer> getAvailableSlotList() {
		if (availableSlotList == null) {
			return createSlotList(MAX_DEFAULT_SIZE);
		}
		return availableSlotList;
	}
}
