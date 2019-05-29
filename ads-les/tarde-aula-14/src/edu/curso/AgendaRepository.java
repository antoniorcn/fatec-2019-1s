package edu.curso;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface AgendaRepository extends CrudRepository<Contato, Long>{

}
