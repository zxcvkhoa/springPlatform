package com.khoa.waterbnb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khoa.waterbnb.models.Bnb;
import com.khoa.waterbnb.repositories.BnbRepository;

@Service
public class BnbService {
private final BnbRepository bnbRepository;
	
	public BnbService(BnbRepository bnbRepository) {
		this.bnbRepository = bnbRepository;
	}
	
	public Bnb createBnb(Bnb bnb) {
		return bnbRepository.save(bnb);
	}
	
	public Bnb findBnb(Long bnbId) {
		Optional<Bnb> optionalBnb = bnbRepository.findById(bnbId);
		if(optionalBnb.isPresent()) {
			return optionalBnb.get();
		}else {
			return null;
		}
	}
	
	public List<Bnb> readAll(){
		return (List<Bnb>) bnbRepository.findAll();
	}

	public void update(Bnb bnb) {
		bnbRepository.save(bnb);
	}

}
