package edu.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgendaController {
	@RequestMapping("/agenda")
	public ModelAndView abrirAgenda() {
		Contato c = new Contato();
		c.setEmail("...@...");
		ModelAndView model = 
				new ModelAndView("agenda", "contato", c);
		return model;
	}
	
	@Autowired
	AgendaService service;
	
	@RequestMapping("/agendaController")
	public ModelAndView agendaController(
			@RequestParam String cmd,  
			@ModelAttribute("contato") Contato c) {
		System.out.println("Agenda Controller acionado");
		System.out.println("Dados do contato: " + c);
		if ("adicionar".equals(cmd)) { 
			service.salvar(c);
		}
		ModelAndView model = 
				new ModelAndView("agenda", "contato", c);
		return model;
	}
}
