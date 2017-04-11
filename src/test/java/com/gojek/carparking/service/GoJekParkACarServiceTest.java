package com.gojek.carparking.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.carparking.vo.ParkingParameter;

public class GoJekParkACarServiceTest {

	private GoJekParkACarService service;

	@Before
	public void setUp() throws Exception {
		service = new GoJekParkACarService();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoAction() {
		ParkingParameter param = new ParkingParameter();
		param.setValue(new String[] { "park", "KA-01-HH-1234", "White" });
		service.doAction(param);
	}

	@Test
	public void tesPakingFull() {
		ParkingParameter param = new ParkingParameter();
		param.setValue(new String[] { "park", "KA-01-HH-9999", "Blue" });
		service.doAction(param);
	}

}
