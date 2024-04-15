package jp.ac.J.ohara.senatyan.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginContoller {
	@GetMapping("/")
	public String getLogin(Model model) {
		return "login";
	}
	@PostMapping("/")
	public String postLogin(Model model) {
		return "redirect:/top/";
	}
}