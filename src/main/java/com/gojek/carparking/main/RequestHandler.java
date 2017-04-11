package com.gojek.carparking.main;

import java.util.HashMap;
import java.util.Map;

import com.gojek.carparking.service.GoJekParkingLotByColorService;
import com.gojek.carparking.service.GoJekRegistrationNoByColorService;
import com.gojek.carparking.vo.ParkingParameter;
import com.gojek.carparking.service.GoJekParkACarService;
import com.gojek.carparking.service.GoJekLeaveParkingService;
import com.gojek.carparking.service.GoJekParkingLotByRegistrationNoService;
import com.gojek.carparking.service.GoJekParkingLotService;
import com.gojek.carparking.service.GoJekParkingService;
import com.gojek.carparking.service.GoJekParkingStatusService;

public class RequestHandler {

	private static Map<String, GoJekParkingService> commandMap;

	public static void handleRequest(String action, String[] values) {
		if (commandMap == null) {
			prepareCommandMap();
		}
		
		GoJekParkingService service = commandMap.get(action);
		ParkingParameter param = new ParkingParameter();
		param.setValue(values);
		service.doAction(param);
	}

	public static void prepareCommandMap() {
		commandMap = new HashMap<>();

		commandMap.put("create_parking_lot", new GoJekParkingLotService());
		commandMap.put("park", new GoJekParkACarService());
		commandMap.put("leave", new GoJekLeaveParkingService());
		commandMap.put("status", new GoJekParkingStatusService());
		commandMap.put("registration_numbers_for_cars_with_colour", new GoJekRegistrationNoByColorService());
		commandMap.put("slot_numbers_for_cars_with_colour", new GoJekParkingLotByColorService());
		commandMap.put("slot_number_for_registration_number", new GoJekParkingLotByRegistrationNoService());
	}

}
