package com.khoa.driverslicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.khoa.driverslicense.models.Person;
import com.khoa.driverslicense.repositories.PersonRepo;


@Service
public class PersonService {
	private final PersonRepo personRepo;
	
	public Person createPerson(Person person) {
		return personRepo.save(person);
	}
	
	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
		
	public Person updatePerson(Person person) {
		return personRepo.save(person);
	}
	
	public void deletePerson(long id) {
		personRepo.deleteById(id);
	}

	public List<Person> readAll(){
		return (List<Person>) personRepo.findAll();
	}
	
}

