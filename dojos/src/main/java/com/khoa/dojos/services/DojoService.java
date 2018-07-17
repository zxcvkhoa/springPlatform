package com.khoa.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khoa.dojos.models.Dojo;
import com.khoa.dojos.repositories.DojoRepo;

@Service
public class DojoService {
	private final DojoRepo dojoRepo;
	
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public List<Dojo> findAllDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo findDojo(Long dojoId) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(dojoId);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
}
