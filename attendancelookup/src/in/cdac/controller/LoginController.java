package in.cdac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showLoginPage() {
		System.out.println("Inside showMyLoginPage");
		return "plainlogin";
	}
	
/*	@RequestMapping("/findht")
	public String findHT() {
		System.out.println("Inside FindHT");
		return "findht";
	}*/
}
