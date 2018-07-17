package com.khoa.dojos.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khoa.dojos.models.Dojo;
import com.khoa.dojos.services.DojoService;

@Controller
public class DojosController {
	private final DojoService dojoService;

	
	public DojosController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		dojo = new Dojo();
		return "/dojos/new.jsp";
	}
	
	@PostMapping("/dojos")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojos/new.jsp";
		} else {
			Dojo createdDojo = dojoService.createDojo(dojo);
			return "redirect:/dojos/" + createdDojo.getId();
		}
	}
	
	@GetMapping("/dojos/{dojoId}")
	public String show(@PathVariable("dojoId") Long dojoId, Model model) {
		Dojo dojo = dojoService.findDojo(dojoId);
		model.addAttribute("dojo", dojo);
		return "/dojos/show.jsp";
	}
}
