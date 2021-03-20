package com.cost.vehicle.controller;

import com.cost.vehicle.entity.Vehicle;
import com.cost.vehicle.service.VehicleService;
import com.cost.vehicle.utils.SimpleVehicleClone;
import com.cost.vehicle.utils.VehicleSort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/prevision")
public class PrevisionResource
{
	@Autowired
	private VehicleService service;

	@RequestMapping(value = "/{gasPrice}/{highwayDistance}/{cityDistance}", method = RequestMethod.GET)
	public ResponseEntity<List<SimpleVehicleClone>> find(@PathVariable Double gasPrice, @PathVariable Double highwayDistance, @PathVariable Double cityDistance)
	{
		List<Vehicle> vehicleList = service.findAll();
		List<SimpleVehicleClone> vehicleCloneList = new ArrayList<>();

		for(Vehicle vehicle : vehicleList)
		{
			SimpleVehicleClone simpleVehicleClone = new SimpleVehicleClone(vehicle, highwayDistance, cityDistance, gasPrice);



			vehicleCloneList.add(simpleVehicleClone);
		}

		VehicleSort comparator = new VehicleSort(highwayDistance, cityDistance, gasPrice);
		Collections.sort(vehicleList, comparator);


		return ResponseEntity.ok().body(vehicleCloneList);
	}
}
