package com.khoa.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khoa.relationships.models.Person;
import com.khoa.relationships.service.PersonService;

@Controller
public class PersonController {
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping("/")
	public String root(Model model) {
		return "redirect:/persons/new";
	}
		
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/driverlicense/newPerson.jsp";
	}
	
	@RequestMapping(value="/persons", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("persons") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "/relationships/newPerson.jsp";
        } else {
            personService.createPerson(person);
            return "redirect:/";
        }
    }
	
	@RequestMapping("/persons/{id}")
	public String show(@PathVariable("id") long id, Model model) {
		Person person = personService.findPerson(id);
		model.addAttribute("person", person);
		return "/driverlicense/show.jsp";
	}
}
