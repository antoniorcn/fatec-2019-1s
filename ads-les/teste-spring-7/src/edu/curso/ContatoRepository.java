package edu.curso;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface ContatoRepository extends CrudRepository<Contato, String> {
    List<Contato> findByNome(String nome);
}
