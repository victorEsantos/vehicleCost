package com.cost.vehicle.utils;

import static org.junit.jupiter.api.Assertions.*;

import com.cost.vehicle.entity.Vehicle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleVehicleSortTest
{

	@Test
	@DisplayName("Teste ordenação de veiculos pelo mais economico")
	public void sortSimpleVehicleList() throws ParseException
	{
		//Arrange
		String errorMsg = "A lista de veiculos não foi ordenada de acordo com a ordem esperada";
		List<SimpleVehicleClone> actualValue = generateCloneVehicleList(false);
		List<SimpleVehicleClone> expectedValue = generateCloneVehicleList(true);
		SimpleVehicleSort comparator = new SimpleVehicleSort();

		List<Integer> expectedValueIdList = generateIdList(expectedValue);


		//Act
		Collections.sort(actualValue, comparator);
		List<Integer> actualValueIdList = generateIdList(actualValue);

		//Assert
		Assertions.assertEquals(expectedValueIdList, actualValueIdList, errorMsg);
	}

	private List<Integer> generateIdList(List<SimpleVehicleClone> vehicleCloneList)
	{
		List<Integer> idList = new ArrayList<>();
		for(SimpleVehicleClone vehicleClone : vehicleCloneList)
		{
			idList.add(vehicleClone.getId());
		}

		return idList;
	}

	private List<SimpleVehicleClone> generateCloneVehicleList(Boolean isShowInOrderly) throws ParseException
	{
		List<SimpleVehicleClone> simpleVehicleCloneList = new ArrayList<>();
		List<Vehicle> vehicleList = generateVehicleList();

		//Veiculo 1 - mais economico de todos
		SimpleVehicleClone svc1 = new SimpleVehicleClone(vehicleList.get(0), 7D, 14D);

		//Veiculo 2 - entre o mais economico e o menos economico
		SimpleVehicleClone svc2 = new SimpleVehicleClone(vehicleList.get(1), 9D, 18D);

		//Veiculo 3 - o menos economico entre os 3 veiculos
		SimpleVehicleClone svc3 = new SimpleVehicleClone(vehicleList.get(2), 11D, 22D);

		if (isShowInOrderly)
		{
			simpleVehicleCloneList.add(svc1);
			simpleVehicleCloneList.add(svc2);
			simpleVehicleCloneList.add(svc3);
		}
		else
		{
			simpleVehicleCloneList.add(svc3);
			simpleVehicleCloneList.add(svc1);
			simpleVehicleCloneList.add(svc2);
		}


		return simpleVehicleCloneList;
	}

	private List<Vehicle> generateVehicleList() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Vehicle vehicleEx1 = new Vehicle(3, "Onix", "Chevrolet", "Onix-turbo",
			sdf.parse("11/12/2018"), 10D, 11D);


		Vehicle vehicleEx2 = new Vehicle(2, "Cruze", "Chevrolet", "Cruze-Sedan3.0",
			sdf.parse("21/10/2020"), 8D, 9D);


		Vehicle vehicleEx3 = new Vehicle(1, "Golf", "VolksWagen", "Golf-GTI",
			sdf.parse("21/10/2020"), 6D, 7D);

		List<Vehicle> vehicleList = Arrays.asList(vehicleEx1, vehicleEx2, vehicleEx3);

		return vehicleList;
	}
}
