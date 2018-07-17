package com.khoa.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khoa.relationships.models.License;
import com.khoa.relationships.service.LicenseService;

@Controller
public class LicenseController {
private final LicenseService licenseService;
	
	public LicenseController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
			
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license) {
		return "/driverlicense/newLicense.jsp";
	}
	
	@RequestMapping(value="/licenses", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("licenses") License license, BindingResult result) {
        if (result.hasErrors()) {
            return "/relationships/newLicense.jsp";
        } else {
            licenseService.createLicense(license);
            return "redirect:/licenses/new";
        }
    }
}
