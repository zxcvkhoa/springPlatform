package com.khoa.dojos.services;

import org.springframework.stereotype.Service;

import com.khoa.dojos.models.Ninja;
import com.khoa.dojos.repositories.NinjaRepo;

@Service
public class NinjaService {
	private final NinjaRepo ninjaRepo;
	
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
}
