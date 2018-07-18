package com.khoa.driverslicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khoa.driverslicense.models.License;
import com.khoa.driverslicense.models.Person;
import com.khoa.driverslicense.services.LicenseService;
import com.khoa.driverslicense.services.PersonService;

@Controller
public class HomeController {
	private final PersonService personService;
	private final LicenseService licenseService;

	public HomeController(PersonService personService, LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }
	
	@RequestMapping("/")
	public String index(Model model) {
		List<License> licenses = licenseService.readAll();
		model.addAttribute("licenses", licenses);
		return "landing.jsp";
	}
	
	@RequestMapping("/persons/new")
	public String person(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		return "person.jsp";
	}
	
	@PostMapping("/addPerson")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
		if(result.hasErrors()) {		
			return "person.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/license/new")
	public String license(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		List<Person> people = personService.readAll();
		model.addAttribute("people", people);
		return "license.jsp";
	}
	
	@PostMapping("/addLicense")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "license.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/";
		}
	}
	
	
}
