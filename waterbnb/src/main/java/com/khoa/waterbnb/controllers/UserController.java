package com.khoa.waterbnb.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.khoa.waterbnb.models.Bnb;
import com.khoa.waterbnb.models.Review;
import com.khoa.waterbnb.models.User;
import com.khoa.waterbnb.services.BnbService;
import com.khoa.waterbnb.services.ReviewService;
import com.khoa.waterbnb.services.UserService;
import com.khoa.waterbnb.validator.UserValidator;


@Controller
public class UserController {
		
	private final UserService userService;
	private final UserValidator userValidator;
	private final BnbService bnbService;
	private final ReviewService reviewService;
	    

	public UserController(UserService userService, UserValidator userValidator, BnbService bnbService, ReviewService reviewService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.bnbService = bnbService;
        this.reviewService = reviewService;
    }
	
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Bnb> bnbList = bnbService.readAll();
		//use this variable below to display in forEach
		model.addAttribute("allListings", bnbList);	
		return "/users/index.jsp";
	}
        
    @RequestMapping("/waterbnb/loginReg")
    public String loginReg(@ModelAttribute("user") User user) {
        return "/users/loginReg.jsp";
    }
	
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "/users/loginReg.jsp";
        }
        User u = userService.registerUser(user);
        session.setAttribute("userId", u.getId());
        return "redirect:/dashboard";
    }
    

 
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	if(userService.authenticateUser(email, password)){
    		session.setAttribute("userId", userService.findByEmail(email).getId()); //Login via session
    		return "redirect:/dashboard";
    	} else {
    		model.addAttribute("error", "Invalid login, please try again");
    		return "/users/loginReg.jsp";
    	}
    }
    
    @RequestMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long user_id = (Long)session.getAttribute("userId");
    	User this_user = userService.findUserById(user_id);
    	model.addAttribute("user", this_user);
    	model.addAttribute("bnb", new Bnb());
		List<Bnb> bnbList = bnbService.readAll();
		//use this variable below to display in forEach
		model.addAttribute("currentListings", bnbList);	
    	return "/users/dashboard.jsp";
    }
    
	@PostMapping("/newBnb")
	public String newBnb(@Valid @ModelAttribute("bnb") Bnb bnb, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
	    	model.addAttribute("bnb", new Bnb());
			List<Bnb> bnbList = bnbService.readAll();
			//use this variable below to display in forEach
			model.addAttribute("currentListings", bnbList);	
			return "/users/dashboard.jsp";
		} else {
			User user = userService.findUserById((Long)session.getAttribute("userId"));
			bnb.setUser(user);
			bnbService.createBnb(bnb);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/waterbnb/{bnbId}")
	public String show(@PathVariable("bnbId") Long bnbId, Model model, HttpSession session) {
		Bnb bnb = bnbService.findBnb(bnbId);
		Long host = bnbService.findBnb(bnbId).getUser().getId();
		User user = userService.findUserById(host);
		model.addAttribute("bnb", bnb);
		model.addAttribute("user", user);
		session.setAttribute("bnbId", bnbId);
		return "/users/show.jsp";
	}
       
//	@RequestMapping("/waterbnb/{bnbId}/review")
//    public String newReview(@PathVariable("bnbId") Long bnbId, HttpSession session, Model model, @ModelAttribute("review") Review review) {
//		Long user_id = (Long)session.getAttribute("userId");
//    	User this_user = userService.findUserById(user_id);
//    	Bnb this_bnb = bnbService.findBnb(bnbId);
//    	model.addAttribute("user", this_user);
//    	model.addAttribute("bnb", this_bnb);
//    	model.addAttribute("review", new Review());
//    	return "/users/review.jsp";
//    }
	
	@RequestMapping("/waterbnb/{bnbId}/review")
    public String review(@PathVariable("bnbId") Long bnbId, HttpSession session, Model model, @ModelAttribute("review") Review review) {
		if(session.getAttribute("bnbId") != null) {
			
			User user = userService.findUserById((Long)session.getAttribute("bnbId"));
			model.addAttribute("user", user);
			
			Bnb bnb = bnbService.findBnb(bnbId);
			model.addAttribute("bnb", bnb);
			
			return "/users/review.jsp";
		} else {
			return "redirect:/waterbnb/" + bnbId;
		}
    }
	
//	@PostMapping("/newReview")
//	public String newReview(@Valid @ModelAttribute("review") Review review, BindingResult result, Model model, HttpSession session) {
//		if(result.hasErrors()) {
//	    	model.addAttribute("review", new Review());
//			return "/users/review.jsp";
//		} else {
//			User user = userService.findUserById((Long)session.getAttribute("userId"));
//			Bnb bnb = bnbService.findBnb((Long)session.getAttribute("bnbId"));
//			review.setUser(user);
//			review.setBnb(bnb);
//			reviewService.createReview(review);
//			return "redirect:/show";
//		}
//	}
	
	
	@PostMapping("/newReview")
	public String newReview(@Valid @ModelAttribute("review") Review review, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
	    	model.addAttribute("review", new Review());
			return "/users/review.jsp";
		} else {
			User user = userService.findUserById((Long)session.getAttribute("bnbId"));
			
			Bnb bnb = bnbService.findBnb((Long)session.getAttribute("bnbId"));
			
			Bnb bnbId = bnbService.findBnb((Long)session.getAttribute("bnbId").getId());
			
			List<Review> reviews = bnb.getReviews();
			reviews.add(review);
			
			bnbService.update(bnb);
			review.setUser(user);
			review.setBnb(bnb);
			reviewService.createReview(review);
			
			return "redirect:/waterbnb/"+ bnbId;
		}
	}
	
	
	
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
}