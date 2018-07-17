package com.khoa.loginregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.khoa.loginregistration.models.User;
import com.khoa.loginregistration.services.UserService;
import com.khoa.loginregistration.validator.UserValidator;


@Controller
public class UserController {
		
	private final UserService userService;
	private final UserValidator userValidator;
	    

	public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
        
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "/users/registrationPage.jsp";
        }
        User u = userService.registerUser(user);
        session.setAttribute("userId", u.getId());
        return "redirect:/home";
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "/users/registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "/users/loginPage.jsp";
    }
   
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	if(userService.authenticateUser(email, password)){
    		session.setAttribute("userId", userService.findByEmail(email).getId()); //Login via session
    		return "redirect:/home";
    	} else {
    		model.addAttribute("error", "Invalid login, please try again");
    		return "/users/loginPage.jsp";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long user_id = (Long)session.getAttribute("userId");
    	User this_user = userService.findUserById(user_id);
    	model.addAttribute("user", this_user);
    	return "/users/homePage.jsp";
    }
    	

       
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/login";
    }
}