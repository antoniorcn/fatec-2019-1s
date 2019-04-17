package edu.curso;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteJPA {
	
	public static void createPlanetas(EntityManagerFactory emf) { 
		Planeta p1 = new Planeta();
		p1.setId(1l);
		p1.setNome("Kripton");
		p1.setDescoberto(new Date());
		p1.setDistanciaSol(4000000);
		p1.setQtdLuas(4);
		p1.setTamanho(67000);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p1);
		em.getTransaction().commit();
		em.close();
	}

	public static void main(String[] args) {
		EntityManagerFactory 
		emf = Persistence.createEntityManagerFactory("PLANETAS");
		createPlanetas(emf);
		emf.close();

	}

}
