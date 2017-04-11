package com.gojek.carparking.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.carparking.domain.Car;
import com.gojek.carparking.storage.GoJekParkingSpace;
import com.gojek.carparking.vo.ParkingParameter;

public class GoJekParkingLotServiceTest {

	private GoJekParkingLotService service;

	@Before
	public void setUp() throws Exception {
		service = new GoJekParkingLotService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoAction() {
		int maxSize = 6;
		ParkingParameter param = new ParkingParameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		service.doAction(param);
		List<Car> availablity = GoJekParkingSpace.getAvailableSlotList();
		assertTrue(availablity.size() == maxSize);

	}

}
