package com.khoa.familiarrouting;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/")
	public String dojo() {
		return "The dojo is awesome!";
	}
	@RequestMapping("/{location}")
	public String showLocation(@PathVariable("location") String location) {
		if(location.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California";
		} if(location.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		} else {
			return location + " location was not found";
		}
		
	}
	
}
 