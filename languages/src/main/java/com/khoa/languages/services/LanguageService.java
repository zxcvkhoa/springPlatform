package com.khoa.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khoa.languages.models.Language;
import com.khoa.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	//returns all the languages
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	//creates a language
	public Language createLanguage(Language language) {
		return languageRepository.save(language);
	}
	
	//retrieves a language
	public Language findLanguage(long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	
	public Language updateLanguage(Language language) {
		return languageRepository.save(language);
	}
	
	public void deleteLanguage(long id) {
		languageRepository.deleteById(id);
	}
}
