package edu.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {
	
	@Autowired AgendaRepository agendaRepository;
	public void save(Contato contato) { 
		agendaRepository.save(contato);
	}

}
