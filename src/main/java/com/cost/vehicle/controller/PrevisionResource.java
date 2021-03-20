package com.cost.vehicle.controller;

import com.cost.vehicle.entity.Vehicle;
import com.cost.vehicle.service.VehicleService;
import com.cost.vehicle.utils.SimpleVehicleClone;
import com.cost.vehicle.utils.SimpleVehicleSort;
import java.util.ArrayList;
import java.util.Calendar;
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
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(vehicle.getProductionDate());


			Double gasSpentOnHighway = highwayDistance / vehicle.getHighwayConsumption();
			Double gasSpentOnCity = cityDistance / vehicle.getCityConsumption();

			Double gasSpentTotal = getGasSpent(gasSpentOnHighway, gasSpentOnCity);
			Double moneySpentWithGas = getMoneySpentWithGas(gasSpentOnHighway, gasSpentOnCity, gasPrice);

			SimpleVehicleClone simpleVehicleClone = new SimpleVehicleClone(vehicle, gasSpentTotal, moneySpentWithGas);

			vehicleCloneList.add(simpleVehicleClone);
		}

		SimpleVehicleSort comparator = new SimpleVehicleSort();
		Collections.sort(vehicleCloneList, comparator);


		return ResponseEntity.ok().body(vehicleCloneList);
	}

	private Double getMoneySpentWithGas(Double gasSpentOnHighway, Double gasSpentOnCity, Double gasPrice)
	{

		Double moneySpentGasInHighway = gasSpentOnHighway * gasPrice;
		Double moneySpentGasInCity = gasSpentOnCity * gasPrice;
		Double moneySpentWithGas = moneySpentGasInCity + moneySpentGasInHighway;

		return moneySpentWithGas;
	}

	private Double getGasSpent(Double gasSpentOnHighway, Double gasSpentOnCity)
	{
		Double gasSpentTotal = gasSpentOnCity + gasSpentOnHighway;

		return gasSpentTotal;
	}
}
