package com.sample.customautowiredcollection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sample.customautowiredcollection.recepts.Recept;


@SpringBootApplication
public class CustomAutowiredCollectionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CustomAutowiredCollectionApplication.class, args);
	}

	@Autowired
	private List<Recept> recepts;
	@Override
	public void run(String... args) throws Exception {
		recepts.forEach(Recept::print);
	}
}
