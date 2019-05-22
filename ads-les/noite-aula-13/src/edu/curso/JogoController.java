package edu.curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JogoController {

	@RequestMapping("/jogo")
	public String jogo() { 
		System.out.println("Controller Jogo executado");
		return "jogo";
	}
		
}
