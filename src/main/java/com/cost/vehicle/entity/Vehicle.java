package com.cost.vehicle.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Vehicle
{
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

	private String name;

	private String brand;

	private String model;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date productionDate;

	private Double cityConsumption;

	private Double highwayConsumption;


	public Vehicle(Integer id, String name, String brand, String model, Date productionDate,
		Double cityConsumption, Double highwayConsumption)
	{
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.model= model;
		this.productionDate = productionDate;
		this.cityConsumption = cityConsumption;
		this.highwayConsumption = highwayConsumption;
	}

	public Vehicle()
	{

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

	public Date getProductionDate()
	{
		return productionDate;
	}

	public Integer getProductionYear()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.getProductionDate());
		Integer productionYear =  calendar.get(Calendar.YEAR);

		return productionYear;
	}

	public void setProductionDate(Date productionDate)
	{
		this.productionDate = productionDate;
	}

	public Double getCityConsumption()
	{
		return cityConsumption;
	}

	public void setCityConsumption(Double cityConsumption)
	{
		this.cityConsumption = cityConsumption;
	}

	public Double getHighwayConsumption()
	{
		return highwayConsumption;
	}

	public void setHighwayConsumption(Double highwayConsumption)
	{
		this.highwayConsumption = highwayConsumption;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return id;
	}

	@Override
	public int hashCode()
	{
		return id != null ? id.hashCode() : 0;
	}
}
