package com.voids.helloHuman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Controller

public class DateController {
	@RequestMapping("/Date")
	public String date(Model model) {
		String year = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
		String month = new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime());
		String weekDay = new SimpleDateFormat("EEEE").format(Calendar.getInstance().getTime());
		String numDay = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
//		Date d = new Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("%W %D %M %Y"); 
//		System.out.println(DateTimeFormatter.ofPattern("dd-mm-yyyy"));
//		
		System.out.println(year);
		System.out.println(month);
		System.out.println(weekDay);
		System.out.println(numDay);
		
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("weekDay", weekDay);
		model.addAttribute("numDay", numDay);
		return "Date.jsp";
	}
}
