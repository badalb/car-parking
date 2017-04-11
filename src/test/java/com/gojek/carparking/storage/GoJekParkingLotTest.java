package com.gojek.carparking.storage;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import com.gojek.carparking.domain.Car;

public class GoJekParkingLotTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSlotCarMap() {
		Map<Integer, Car> slotCarMap = GoJekParkingLot.getSlotCarMap();
		assertTrue(slotCarMap.isEmpty() == true);
	}

}
