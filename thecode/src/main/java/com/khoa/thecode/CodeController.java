package com.khoa.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	@RequestMapping("/")
	public String index(@ModelAttribute("errors") String errors) {
		System.out.println(errors);
		return "index.jsp";
	}
	@RequestMapping(path="/guess", method=RequestMethod.POST)
	public String submit(@RequestParam(value="attempt") String guess) {
		if(guess.equals("bushido")) {
			return "redirect:/code";
		} else {
			return "redirect:/errors";
		}
	}
	@RequestMapping("/code")
	public String correctCode() {
		return "code.jsp";
	}
	@RequestMapping("/errors")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errors", "You must train harder!");
		return "redirect:/";
	}
}

