package edu.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.curso.entidade.Pessoa;	

@Controller
public class AgendaController {
	@Autowired
	private AgendaService agendaService;
	
	@RequestMapping("/agenda")
	public ModelAndView agenda() { 
		Pessoa pessoa = new Pessoa();
		pessoa.setEmail("...@...");
		return new ModelAndView("agenda", "pessoa", pessoa);
	}
	@RequestMapping("/agendaCommand")
	public ModelAndView agendaCommand(@RequestParam String cmd,  @ModelAttribute("pessoa") Pessoa pessoa) {
		System.out.println("Pessoa recebida como atributo: " + pessoa);
		if ("adicionar".equals(cmd)) {
			if (pessoa != null) {
				System.out.println(
					String.format("Pessoa: %s adicionada ao database", pessoa.getNome()));
				agendaService.salvar(pessoa);
			}
		} else if ("pesquisar".equals(cmd)) {
			System.out.println(
					String.format("Procurando pessoa: %s no banco de dados", pessoa.getNome()));
			pessoa = new Pessoa();
			pessoa.setNome("Joao 1");
			pessoa.setTelefone("1234567");
			pessoa.setEmail("joao@teste.com");
		}
		ModelAndView model = new ModelAndView("agenda", "pessoa", pessoa);
		return model; 
	}
}
