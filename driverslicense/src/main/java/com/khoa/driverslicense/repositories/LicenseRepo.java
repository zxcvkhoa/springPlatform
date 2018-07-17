package com.khoa.driverslicense.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khoa.driverslicense.models.License;


@Repository
public interface LicenseRepo extends CrudRepository<License, Long>{

}

