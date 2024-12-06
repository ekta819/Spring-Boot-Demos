package learn.sb.web3.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import learn.sb.web3.main.entities.User;
import learn.sb.web3.main.services.UserService;

@Controller
public class MyController {

	@Autowired
	UserService userService;

	// Using MODEL & model.addAttribute to send data from CONTROLLER to VIEW i.e
	// here empty USER Object to View (FORM)
	// It allows attributes to be added and accessed during rendering of view pages
	@GetMapping("/regPage")
	public String openRegPage(Model model) {
		model.addAttribute("model_user", new User());
		return "register";
	}

	// Using @ModelAttribute to bind FORM data to Model Object
	// It passes the data from HTML (${model_user}) to Controller (user1) and also
	// populates the model with Data
	// making it available to view.
	
	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("model_user") User user1, Model model
	/* model to print msg */) {
		boolean sts = userService.registerUser(user1);
		if (sts) {
			model.addAttribute("succMsg", "User registered successfully");
		}

		else {
			model.addAttribute("errorMsg", "User NOT registered due to error");
		}
		return "register";
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		model.addAttribute("model_user",new User());
		return "login";
	}
	
	
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("model_user") User user1, Model model
	/* model to print msg */) {
		User loggedInUser = userService.loginUser(user1.getEmail(), user1.getPassword());
		if (loggedInUser!=null) {
			return "profile";
		}

		else {
			model.addAttribute("errorMsg", "User NOT logged in due to error");
			return "login";
		}
		
	}
	

}
