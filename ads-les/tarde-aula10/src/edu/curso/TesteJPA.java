package edu.curso;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
public class TesteJPA {
	public static void criarInstancia(EntityManagerFactory emf) { 
		Aluno a1 = new Aluno();
		a1.setId(1);
		a1.setNascimento(new Date());
		a1.setNome("Antonio Carvalho");
		a1.setRa("000001");
		
		Aluno a2 = new Aluno();
		a2.setId(2);
		a2.setNascimento(new Date());
		a2.setNome("Andre");
		a2.setRa("000002");
		
		SalaAula s1 = new SalaAula();
		s1.setId(1);
		s1.setNumero("102");
		s1.setDisciplina("Laboratorio de Engenharia de SW");
		s1.setCapacidade(40);
		List<Aluno> alunos = new ArrayList<>();
		alunos.add(a1);
		alunos.add(a2);
		s1.setAlunos(alunos);
		
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(a1);
		em.persist(a2);
		em.persist(s1);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void atualizar(EntityManagerFactory emf) { 
		EntityManager em = emf.createEntityManager();
		Aluno a = em.find(Aluno.class, 1l);
		em.getTransaction().begin();
		a.setRa("111111");
		em.getTransaction().commit();
		em.close();
	}
	
	
	public static void pesquisarTodos(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Aluno> qry = 
				em.createQuery("select a from Aluno a", Aluno.class);
		List<Aluno> alunos = qry.getResultList();
		for (Aluno a : alunos) { 
			System.out.println(a);
		}
		em.close();
	}
	
	public static void pesquisarTodasSalas(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<SalaAula> qry = 
				em.createQuery("select a from SalaAula a", SalaAula.class);
		List<SalaAula> salas = qry.getResultList();
		for (SalaAula a : salas) { 
			System.out.println(a);
		}
		em.close();
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("ALUNOS");
		pesquisarTodasSalas(emf);
		emf.close();
	}
}
