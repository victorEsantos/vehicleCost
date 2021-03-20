package com.cost.vehicle;

import com.cost.vehicle.entity.Vehicle;
import com.cost.vehicle.repositoriesDAO.VehicleRepository;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehiclesApplication  implements CommandLineRunner
{

	@Autowired
	private VehicleRepository vehicleRepository;

	public static void main(String[] args)
	{
		SpringApplication.run(VehiclesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Vehicle vehicleEx1 = new Vehicle(null, "Golf", "VolksWagen", "Golf-GTI",
			sdf.parse("21/10/2020"), 6D, 7D);

		Vehicle vehicleEx2 = new Vehicle(null, "Onix", "Chevrolet", "Onix-turbo",
			sdf.parse("11/12/2018"), 10D, 11D);

		Vehicle vehicleEx3 = new Vehicle(null, "Cruze", "Chevrolet", "Cruze-Sedan3.0",
			sdf.parse("21/10/2020"), 8D, 9D);
		
		vehicleRepository.saveAll(Arrays.asList(vehicleEx1, vehicleEx2, vehicleEx3));
	}
}
