package com.cost.vehicle.controller;

import com.cost.vehicle.entity.Vehicle;
import com.cost.vehicle.service.VehicleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/prevision")
public class PrevisionResource
{
	@Autowired
	private VehicleService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Vehicle>> findAll()
	{
		List<Vehicle> objList = service.findAll();

		return ResponseEntity.ok().body(objList);
	}
}
