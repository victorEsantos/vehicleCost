package com.cost.vehicle.utils;

import com.cost.vehicle.entity.Vehicle;
import java.util.Comparator;


public class VehicleSort implements Comparator<Vehicle>
{
	Double highwayDistance;
	Double cityDistance;
	Double gasPrice;

	public VehicleSort(Double highwayDistance, Double cityDistance, Double gasPrice)
	{
		this.highwayDistance = highwayDistance;
		this.cityDistance = cityDistance;
		this.gasPrice = gasPrice;
	}

	@Override
	public int compare(Vehicle o1, Vehicle o2)
	{
		int cmp = 0;

		Double moneySpentOnVehicle1 = calcAllMoneySpentFromVehicle(o1);

		Double moneySpentOnVehicle2 = calcAllMoneySpentFromVehicle(o2);

		cmp = moneySpentOnVehicle1.compareTo(moneySpentOnVehicle2);

		//se tiver o mesmo gasto o desempate é feito pelo ID
		cmp = cmp == 0 ? o1.getId().compareTo(o2.getId()) : cmp;

		return cmp;
	}

	private Double calcAllMoneySpentFromVehicle(Vehicle vehicle)
	{
		Double highwayConsumption = vehicle.getHighwayConsumption();
		Double gasSpentOnHighway = highwayDistance / highwayConsumption;
		Double moneySpentGasInHighway = gasSpentOnHighway * gasPrice;

		Double cityConsumption = vehicle.getCityConsumption();
		Double gasSpentOnCity = cityDistance / cityConsumption;
		Double moneySpentGasInCity = gasSpentOnCity * gasPrice;

		return moneySpentGasInHighway + moneySpentGasInCity;
	}


}
