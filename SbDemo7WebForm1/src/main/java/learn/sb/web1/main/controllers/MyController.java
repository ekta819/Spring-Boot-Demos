package learn.sb.web1.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import learn.sb.web1.main.entities.User;
import learn.sb.web1.main.service.UserService;

@Controller
public class MyController {
	
	@Autowired
	private UserService userService;
	
	//v-14 - 30:00
	@GetMapping("/regPage")
	public String openRegPage(Model model) {
		model.addAttribute("u", new User());
		return "register";
	}
	
	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("u") User user, Model model) {
		boolean status=userService.registerUser(user);
		if(status) {
			model.addAttribute("sucessMsg", "User regitered succesfully");
		}
		else {
			model.addAttribute("errorMsg", "User not registerd due to error");
			
		}
		return "register";
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		model.addAttribute("u", new User());
		
		return "login";
	}
	
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("u") User user, Model model) {
		
		User validUser=userService.loginUser(user.getEmail(), user.getPassword());
		if(validUser!=null) {
			model.addAttribute("modelName", validUser.getName());
			return "profile";
		}
		else {
			model.addAttribute("errorMsg", "User not logged in due to email and password didn't matched");
			return "login";
		}

		
	} 
	
	@GetMapping("/logout")
	public String logoutUser(HttpServletRequest request) {
		
		HttpSession session=request.getSession(false);
		if(session!=null) {
			session.invalidate();
		}
		return "login";
		
		
	}
	
	

}
