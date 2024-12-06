package learn.sb.web2.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("/openProfile")
	public String openProfilePage(Model model) {
		String name="Doraemon";
		model.addAttribute("model_name", name);
		return "profile";
	}
	
	@GetMapping("/openConditional")
	public String openConditionalPage(Model model) {
		int num1=10;
		int num2=40;
		model.addAttribute("model_num1", num1);
		model.addAttribute("model_num2", num2);
		return "conditional";
		
	}
	
	@GetMapping("/openLooping")
	public String openLoopingPage(Model model) {
		List<Integer> list=List.of(1,2,3,4,5);
		model.addAttribute("model_list", list);
		return "looping";
		
	}

}
