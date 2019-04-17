package edu.curso;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class TesteJPA {
	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		a1.setId(1);
		a1.setNascimento(new Date());
		a1.setNome("Antonio Carvalho");
		a1.setRa("000001");
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("ALUNOS");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(a1);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
