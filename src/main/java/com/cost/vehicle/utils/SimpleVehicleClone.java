package com.cost.vehicle.utils;

import com.cost.vehicle.entity.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SimpleVehicleClone
{
	@JsonIgnore
	private Integer id;
	private String name;
	private String brand;
	private String model;
	private Integer productionYear;
	private Double gasSpentTotal;
	private Double moneySpentWithGas;

	public SimpleVehicleClone(Vehicle v, Integer productionYear, Double gasSpentTotal, Double moneySpentWithGas)
	{
		this.id = v.getId();
		this.name = v.getName();
		this.brand = v.getBrand();
		this.model = v.getModel();
		this.productionYear = productionYear;
		this.gasSpentTotal = gasSpentTotal;
		this.moneySpentWithGas = moneySpentWithGas;
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
