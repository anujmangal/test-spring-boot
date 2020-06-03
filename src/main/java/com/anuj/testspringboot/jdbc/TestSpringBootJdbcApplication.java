package com.anuj.testspringboot.jdbc;

import com.anuj.testspringboot.jdbc.beans.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
public class TestSpringBootJdbcApplication implements CommandLineRunner {

	@Autowired
	private PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(TestSpringBootJdbcApplication.class, args);

	}

	@Override
	public void run(String... args) {

		//Get All Persons
		List<Person> allPersons = personJdbcDao.getAllPersons();
		System.out.println(allPersons);

		//Insert Person
		Person person = new Person(1001, "New Person", "Adelaide", LocalDate.now());
		System.out.println("Insert Person : " + personJdbcDao.insertPerson(person));

		//Insert another person
		person = new Person(1002, "New Person 2", "Alice Springs", LocalDate.now());
		System.out.println("Insert Person : " + personJdbcDao.insertPerson(person));

		allPersons = personJdbcDao.getAllPersons();
		System.out.println(allPersons);

		//Update Person
		System.out.println("Update Person : -> " + personJdbcDao.updatePerson("Updated Person", 1001));

		allPersons = personJdbcDao.getAllPersons();
		System.out.println(allPersons);

		//Delete Person
		System.out.println("Delete Person : -> " + personJdbcDao.deleteById(1002));

		allPersons = personJdbcDao.getAllPersons();
		System.out.println(allPersons);

	}
}
