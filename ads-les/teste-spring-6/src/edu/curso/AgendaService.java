package edu.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.entidade.Pessoa;

@Service
public class AgendaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public void salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

}
