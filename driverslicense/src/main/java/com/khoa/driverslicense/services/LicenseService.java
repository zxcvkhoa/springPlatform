package com.khoa.driverslicense.services;

import org.springframework.stereotype.Service;

import com.khoa.driverslicense.models.License;
import com.khoa.driverslicense.models.Person;
import com.khoa.driverslicense.repositories.LicenseRepo;

@Service
public class LicenseService {
	private final LicenseRepo licenseRepo;
	
	public License createLicense(License license) {
		return licenseRepo.save(license);
	}
	
	public LicenseService(LicenseRepo licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
		
	public License updateLicense(License license) {
		return licenseRepo.save(license);
	}
	
	public void deleteLicense(long id) {	
		licenseRepo.deleteById(id);
	}
	
}