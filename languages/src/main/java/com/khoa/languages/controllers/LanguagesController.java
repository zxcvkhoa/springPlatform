package com.khoa.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khoa.languages.models.Language;
import com.khoa.languages.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService languageService;
	
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String root(Model model) {
		List<Language> language = languageService.allLanguages();
		model.addAttribute("languages", language);
		return "/languages/index.jsp";
	}
	
	@RequestMapping("/languages")
	public String index(Model model) {
		List<Language> language = languageService.allLanguages();
		model.addAttribute("languages", language);
		return "/languages/index.jsp";
	}
	
//	@RequestMapping("/languages/new")
//    public String newLanguage(@ModelAttribute("language") Language language) {
//        return "/languages/index.jsp";
//    }
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("languages") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/index.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
	
	@RequestMapping("/languages/{id}")
	public String show(@PathVariable("id") long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "/languages/show.jsp";
	}
	
	 @RequestMapping("/languages/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Language language = languageService.findLanguage(id);
	        model.addAttribute("language", language);
	        return "/languages/edit.jsp";
	}
	 
	 @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("languages") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/languages/edit.jsp";
	        } else {
	            languageService.updateLanguage(language);
	            return "redirect:/languages";
	        }
	    }
	 
	 @RequestMapping(value="/languages/delete/{id}", method=RequestMethod.GET)
	    public String destroy(@PathVariable("id") Long id) {
	        languageService.deleteLanguage(id);
	        return "redirect:/languages";
	    }
	
	
}
