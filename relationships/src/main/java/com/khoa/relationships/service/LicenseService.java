package com.khoa.relationships.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khoa.relationships.models.License;
import com.khoa.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	//returns all the licenses
	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}
	
	//creates a license
	public License createLicense(License license) {
		return licenseRepository.save(license);
	}
	
	//retrieves a license
	public License findLicense(long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
	
	
	public License updateLicense(License license) {
		return licenseRepository.save(license);
	}
	
	public void deleteLicense(long id) {
		licenseRepository.deleteById(id);
	}
}
