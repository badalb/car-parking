package com.gojek.carparking.storage;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoJekParkingAvailablityTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateSlotList() {
		int maxSize = 10;
		List<Integer> availablity = GoJekParkingAvailablity.createSlotList(maxSize);
		assertTrue(availablity.size() == maxSize);
	}

	@Test
	public void testGetAvailableSlotList() {
		int maxSize = 10;
		List<Integer> availablity = GoJekParkingAvailablity.getAvailableSlotList();
		assertTrue(availablity.size() == maxSize);
	}

}
