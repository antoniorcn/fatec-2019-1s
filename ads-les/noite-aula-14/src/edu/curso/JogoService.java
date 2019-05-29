package edu.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogoService {
	
	@Autowired
	JogoRepository jogoRepo;
	
	public void adicionar(Jogo j) { 
		jogoRepo.save(j);
	}
	
	public List<Jogo> pesquisarPeloTipo(String tipo) { 
		return jogoRepo.findByTipo(tipo);
	}

}
