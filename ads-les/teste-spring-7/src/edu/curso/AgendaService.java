package edu.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {
	@Autowired
	ContatoRepository repository;
	
	public void salvar(Contato c) { 
		repository.save(c);
	}
}
