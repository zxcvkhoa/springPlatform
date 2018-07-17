package com.khoa.driverslicense.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khoa.driverslicense.models.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {

}
