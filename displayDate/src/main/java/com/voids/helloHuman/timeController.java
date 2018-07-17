package com.voids.helloHuman;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class timeController {
	@RequestMapping("/Time")
	public String time(Model model) {
		String time = new SimpleDateFormat("h:mm a").format(Calendar.getInstance().getTime());
		model.addAttribute("time", time);
		return "Time.jsp";
	}
}
