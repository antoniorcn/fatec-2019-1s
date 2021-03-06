package edu.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		String message = "<h1>Hello World</h1>";
		return new ModelAndView("welcome", "message", message);
	}
}
