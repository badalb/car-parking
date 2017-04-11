package com.gojek.carparking.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.carparking.vo.ParkingParameter;

public class GoJekLeaveParkingServiceTest {

	GoJekLeaveParkingService leaveParkingService;

	private GoJekParkACarService parkingService;

	private GoJekParkingLotService service;

	@Before
	public void setUp() throws Exception {
		leaveParkingService = new GoJekLeaveParkingService();
		parkingService = new GoJekParkACarService();
		service = new GoJekParkingLotService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoAction() {

		ParkingParameter param = new ParkingParameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		service.doAction(param);

		param.setValue(new String[] { "park", "KA-01-HH-1234", "White" });
		parkingService.doAction(param);

		param.setValue(new String[] { "leave", "1" });
		leaveParkingService.doAction(param);

	}

}
