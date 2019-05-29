package edu.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JogoController {
	@Autowired
	JogoService jogoService;

	@RequestMapping("/jogo")
	public ModelAndView jogo() {
		Jogo j = new Jogo();
		j.setNome("Pacman");
		ModelAndView mv = new ModelAndView("jogo", "jogo", j);
		System.out.println("Jogo foi executado");
		return mv;
	}
		
	@RequestMapping("/jogoController")
	public ModelAndView jogoController(
			@ModelAttribute("jogo") Jogo j,
			@RequestParam("cmd") String cmd) {
		System.out.println("Jogo Controller foi executado");
		System.out.println("Foi apertado o botão: " + cmd);
		System.out.println("Nome do Jogo: " + j.getNome());
		System.out.println("Tipo do Jogo: " + j.getTipo());
		System.out.println("\n");
		jogoService.adicionar(j);
		
		
		List<Jogo> lista = jogoService.pesquisarPeloTipo("Plataforma");
		for (Jogo jogo : lista) { 
			System.out.println("Nome: " + jogo.getNome() + "Tipo: " + jogo.getTipo());
		}
		ModelAndView mv = new ModelAndView("jogo", "jogo", j);
		return mv;
	}
}
