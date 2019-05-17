package edu.curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/bemvindo")
	public ModelAndView bemvindo() {
		String message = "Ola bem vindo ao ThymeLeaf";
		System.out.println(message);
		ModelAndView model = new ModelAndView("helloworld", "message", message);
		return model;
	}

}
