package com.gojek.carparking.storage;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoJekParkingSearchMapTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSlotCarMap() {
		GoJekParkingSearchMap.initializeSearchMap();
		Map<String, Integer> slotCarMap = GoJekParkingSearchMap.getSlotRegistrationNoMap();
		assertTrue(slotCarMap.isEmpty() == true);
	}

}
