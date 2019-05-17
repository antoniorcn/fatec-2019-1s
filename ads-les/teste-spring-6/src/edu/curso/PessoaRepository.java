package edu.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.curso.entidade.Pessoa;

@Repository("pessoaRepository")
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
