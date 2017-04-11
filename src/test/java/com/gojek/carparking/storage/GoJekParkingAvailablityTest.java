package com.gojek.carparking.storage;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.carparking.domain.Car;

public class GoJekParkingAvailablityTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateSlotList() {
		int maxSize = 6;
		List<Car> availablity = GoJekParkingSpace.createSlotList(maxSize);
		assertTrue(availablity.size() == maxSize);
	}

	@Test
	public void testGetAvailableSlotList() {
		int maxSize = 6;
		List<Car> availablity = GoJekParkingSpace.getAvailableSlotList();
		assertTrue(availablity.size() == maxSize);
	}

}
