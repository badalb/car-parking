package com.gojek.carparking.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.carparking.vo.ParkingParameter;

public class GoJekRegistrationNoByColorServiceTest {

	private GoJekParkACarService parkingService;

	private GoJekRegistrationNoByColorService regNoByColorService;
	
	private GoJekParkingLotService lotService;

	@Before
	public void setUp() throws Exception {
		parkingService = new GoJekParkACarService();
		regNoByColorService = new GoJekRegistrationNoByColorService();
		lotService = new GoJekParkingLotService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoAction() {

		ParkingParameter param = new ParkingParameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		lotService.doAction(param);

		param.setValue(new String[] { "park", "KA-01-HH-1234", "White" });
		parkingService.doAction(param);

		param.setValue(new String[] { "registration_numbers_for_cars_with_colour", "White" });
		regNoByColorService.doAction(param);

		param.setValue(new String[] { "registration_numbers_for_cars_with_colour", "White" });
		regNoByColorService.doAction(param);
	}

}
