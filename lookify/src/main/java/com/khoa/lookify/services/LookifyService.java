package com.khoa.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khoa.lookify.models.Lookify;
import com.khoa.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
private final LookifyRepository lookifyRepository;
	
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	
	//returns all the songs
	public List<Lookify> allLookifys(){
		return lookifyRepository.findAll();
	}
	
	//creates a song
	public Lookify createLookify(Lookify lookify) {
		return lookifyRepository.save(lookify);
	}
	
	//retrieves a song
	public Lookify findLookify(long id) {
		Optional<Lookify> optionalLookify = lookifyRepository.findById(id);
		if(optionalLookify.isPresent()) {
			return optionalLookify.get();
		} else {
			return null;
		}
	}
	
	
	public Lookify updateLookify(Lookify lookify) {
		return lookifyRepository.save(lookify);
	}
	
	public void deleteLookify(long id) {
		lookifyRepository.deleteById(id);
	}
	
	public List<Lookify> sortSongs(){
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
}
