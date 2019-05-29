package edu.curso;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface JogoRepository extends CrudRepository<Jogo, Long>{
	List<Jogo> findByTipo(String tipo);

}
