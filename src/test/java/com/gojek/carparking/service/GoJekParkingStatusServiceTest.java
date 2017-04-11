package com.gojek.carparking.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.carparking.vo.ParkingParameter;

public class GoJekParkingStatusServiceTest {

	private GoJekParkingStatusService parkingStatusService;

	private GoJekParkACarService parkingService;

	@Before
	public void setUp() throws Exception {

		parkingService = new GoJekParkACarService();

		parkingStatusService = new GoJekParkingStatusService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoAction() {
		ParkingParameter param = new ParkingParameter();

		param.setValue(new String[] { "status" });
		parkingStatusService.doAction(param);

		param.setValue(new String[] { "park", "KA-01-HH-1234", "White" });
		parkingService.doAction(param);

		param.setValue(new String[] { "status" });
		parkingStatusService.doAction(param);

	}

}
