package com.cost.vehicle.service;

import com.cost.vehicle.controller.exception.DataIntegrityException;
import com.cost.vehicle.controller.exception.ObjectNotFoundException;
import com.cost.vehicle.entity.Vehicle;
import com.cost.vehicle.repositoriesDAO.VehicleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class VehicleService
{
	@Autowired
	VehicleRepository repository;

	public Vehicle find(Integer id)
	{
		Optional<Vehicle> obj = repository.findById(id);

		//Se objeto for null lanca custom exception
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Object not fount Id: " + id + ", Type: " + Vehicle.class.getName()));
	}

	public List<Vehicle> findAll()
	{
		return repository.findAll();
	}

	public Vehicle insert(Vehicle obj)
	{
		obj.setId(null);
		return repository.save(obj);
	}

	public Vehicle update(Vehicle vehicle)
	{
		return repository.save(vehicle);
	}

	private void updateVehicleData(Vehicle newVehicle, Vehicle vehicle)
	{
		newVehicle.setName(vehicle.getName());
		//brand model productionDate city high
		newVehicle.setBrand(vehicle.getBrand());
		newVehicle.setModel(vehicle.getModel());

	}

	public void delete(Integer vehicleId)
	{
		find(vehicleId);
		try
		{
			repository.deleteById(vehicleId);
		}
		catch (DataIntegrityViolationException e)
		{
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
		}
	}



}

