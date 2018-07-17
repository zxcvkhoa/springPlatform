package com.khoa.dojos.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.khoa.dojos.models.Ninja;
import com.khoa.dojos.services.DojoService;
import com.khoa.dojos.services.NinjaService;

@Controller
public class NinjasController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public NinjasController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("allDojos", dojoService.findAllDojos());
		return "/ninjas/new.jsp";
	}
	
	@PostMapping("/ninjas")
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/ninjas/new.jsp";
		} else {
			Ninja createdNinja = ninjaService.createNinja(ninja);
			return "redirect:/dojos/" + createdNinja.getDojo().getId();
		}
	}
}
