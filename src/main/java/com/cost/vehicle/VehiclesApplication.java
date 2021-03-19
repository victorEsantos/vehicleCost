package com.cost.vehicle;

import com.cost.vehicle.entity.Vehicle;
import com.cost.vehicle.repositoriesDAO.VehicleRepository;
import java.text.SimpleDateFormat;
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

		Vehicle vehicleEx = new Vehicle(null, "name", "brand", "model",
			sdf.parse("21/10/2001"), 10D, 7D);

		vehicleRepository.save(vehicleEx);
	}
}
