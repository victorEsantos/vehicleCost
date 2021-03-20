package com.cost.vehicle.utils;

import com.cost.vehicle.entity.Vehicle;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleVehicleClone
{
	private Integer id;
	private String name;
	private String brand;
	private String model;

	private int productionYear;
	private Double gasSpentTotal;
	private Double moneySpentWithGas;

	//FIX-ME regra de negócio no construtor não está legal!
	//FIX-ME regra de negócio no construtor não está legal!
	//FIX-ME regra de negócio no construtor não está legal!
	//FIX-ME regra de negócio no construtor não está legal!
	//FIX-ME regra de negócio no construtor não está legal!
	public SimpleVehicleClone(Vehicle v, Double highwayDistance, Double cityDistance, Double gasPrice)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		this.id = v.getId();
		this.name = v.getName();
		this.brand = v.getBrand();
		this.model = v.getModel();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(v.getProductionDate());
		this.productionYear =  calendar.get(Calendar.YEAR);


		Double highwayConsumption = v.getHighwayConsumption();
		Double gasSpentOnHighway = highwayDistance / highwayConsumption;
		Double moneySpentGasInHighway = gasSpentOnHighway * gasPrice;

		Double cityConsumption = v.getCityConsumption();
		Double gasSpentOnCity = cityDistance / cityConsumption;
		Double moneySpentGasInCity = gasSpentOnCity * gasPrice;


		this.gasSpentTotal = gasSpentOnCity + gasSpentOnHighway;
		this.moneySpentWithGas = moneySpentGasInCity + moneySpentGasInHighway;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public int getProductionYear()
	{
		return productionYear;
	}

	public void setProductionYear(int productionYear)
	{
		this.productionYear = productionYear;
	}

	public Double getGasSpentTotal()
	{
		return gasSpentTotal;
	}

	public void setGasSpentTotal(Double gasSpentTotal)
	{
		this.gasSpentTotal = gasSpentTotal;
	}

	public Double getMoneySpentWithGas()
	{
		return moneySpentWithGas;
	}

	public void setMoneySpentWithGas(Double moneySpentWithGas)
	{
		this.moneySpentWithGas = moneySpentWithGas;
	}
}
