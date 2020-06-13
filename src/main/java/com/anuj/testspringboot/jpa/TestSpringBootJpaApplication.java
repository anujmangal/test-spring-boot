package com.anuj.testspringboot.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
public class TestSpringBootJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestSpringBootJpaApplication.class, args);

	}

	@Override
	public void run(String... args){

		//Get All Persons
		List<PersonEntity> allPersons = personJpaRepository.getAllPersons();
		System.out.println(allPersons);

		//Insert Person
		PersonEntity person = new PersonEntity("New Person", "Adelaide", LocalDate.now());
		System.out.println("Insert Person : " + personJpaRepository.insertPerson(person));

		allPersons = personJpaRepository.getAllPersons();
		System.out.println(allPersons);

		//Update Person
		PersonEntity updatedPerson = new PersonEntity(102, "Updated Person", "Adelaide", LocalDate.now());
		System.out.println("Update Person : -> " + personJpaRepository.updatePerson(updatedPerson));

		allPersons = personJpaRepository.getAllPersons();
		System.out.println(allPersons);

	}
}
