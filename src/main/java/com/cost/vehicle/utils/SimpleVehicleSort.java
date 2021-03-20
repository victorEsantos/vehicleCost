package com.cost.vehicle.utils;

import java.util.Comparator;


public class SimpleVehicleSort implements Comparator<SimpleVehicleClone>
{

	public SimpleVehicleSort()
	{
	}

	@Override
	public int compare(SimpleVehicleClone o1, SimpleVehicleClone o2)
	{
		int cmp = 0;

		Double moneySpentOnVehicle1 = o1.getMoneySpentWithGas();

		Double moneySpentOnVehicle2 = o2.getMoneySpentWithGas();

		cmp = moneySpentOnVehicle1.compareTo(moneySpentOnVehicle2);

		//se tiver o mesmo gasto o desempate é feito pelo ID
		if(cmp == 0 && o1.getId() != null && o2.getId() != null)
		{
			cmp =  o1.getId().compareTo(o2.getId());
		}

		return cmp;
	}

}
