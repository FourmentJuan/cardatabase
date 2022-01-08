package com.packt.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepositoy;

@SpringBootApplication
public class CardatabaseApplication {
	//Inject repositories
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepositoy orepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}
	@Bean
	
	CommandLineRunner runner() {
		return args -> {
			// Add owner objects and save these to db
			Owner owner1 = new Owner("Jhon", "Johson");
			Owner owner2 = new Owner("Mary", "Robinson");
			orepository.save(owner1);
			orepository.save(owner2);
			
			// Add car object with link to owners and save these to db
			Car car = new Car("Ford","Mustang","Red","ADF-1121",2017,59000,owner1);
			repository.save(car);
			
			car = new Car("Nissan","Leaf","White","SSJ-3002",2014,29000,owner1);
			repository.save(car);
			
			car = new Car("Toyota","Rpius","Silver","KK-0212",2018,39000, owner2);
			repository.save(car);
			
			car = new Car("Renult","Stepway","Red","AAX-1456",2014,10000, owner2);
			repository.save(car);
			
		};
	}
	

}
