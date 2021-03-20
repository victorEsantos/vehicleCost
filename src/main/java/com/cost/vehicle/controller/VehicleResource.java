package com.cost.vehicle.controller;

import com.cost.vehicle.entity.Vehicle;
import com.cost.vehicle.service.VehicleService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleResource
{
	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vehicle> find(@PathVariable Integer id)
	{
		Vehicle vehicle = vehicleService.find(id);
		return ResponseEntity.ok().body(vehicle);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Vehicle vehicle)
	{
		Vehicle obj = vehicleService.insert(vehicle);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Vehicle>> findAll()
	{
		List<Vehicle> objList = vehicleService.findAll();

		return ResponseEntity.ok().body(objList);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Vehicle vehicle, @PathVariable Integer id)
	{
		vehicle.setId(id);
		Vehicle obj = vehicleService.update(vehicle);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id)
	{
		vehicleService.delete(id);

		return ResponseEntity.noContent().build();
	}

}
