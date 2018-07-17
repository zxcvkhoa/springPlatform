package com.khoa.springcounter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CounterController {
	public static Integer count = 0;

	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("count", CounterController.count++);
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if(count == null) {
			session.setAttribute("count", CounterController.count++);
		}
		return "counter.jsp";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		count = 0;
		return "counter.jsp";
	}
	@RequestMapping("/plustwo")
		public String plustwo(HttpSession session) {
			Integer count = (Integer) session.getAttribute("count");
			if(count == null) {
				session.setAttribute("count", CounterController.count+=2);
			}
			return "counter.jsp";
		}
	}

