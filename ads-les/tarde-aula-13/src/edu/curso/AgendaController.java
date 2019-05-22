package edu.curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgendaController {	
//	@RequestMapping("/agenda")
//	public String agenda() { 
//		System.out.println("Controller executado");
//		return "agenda";
//	}
	
	@RequestMapping("/agenda")
	public ModelAndView agenda() { 
		Contato c = new Contato();
		c.setEmail("...@...");
		ModelAndView mv = new ModelAndView("agenda", "contato", c);
		return mv;
	}
}
