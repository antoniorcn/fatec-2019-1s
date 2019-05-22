package edu.curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/agendaProcessa")
	public ModelAndView agendaProcessa(
			@ModelAttribute("contato") Contato c,
			@RequestParam("cmd") String cmd) {
		System.out.println("Botao Apertado: " + cmd);
		System.out.println("Nome: " + c.getNome());
		System.out.println("Email: " + c.getEmail());
		System.out.println("Telefone: " + c.getTelefone());
		c = new Contato();
		ModelAndView mv = new ModelAndView("agenda", "contato", c);
		return mv;
	}
}
