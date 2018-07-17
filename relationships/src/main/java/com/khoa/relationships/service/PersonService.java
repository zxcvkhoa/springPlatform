package com.khoa.relationships.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khoa.relationships.models.Person;
import com.khoa.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	//returns all the persons
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
	
	//creates a person
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	//retrieves a person
	public Person findPerson(long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
	
	
	public Person updatePerson(Person person) {
		return personRepository.save(person);
	}
	
	public void deletePerson(long id) {
		personRepository.deleteById(id);
	}
}
