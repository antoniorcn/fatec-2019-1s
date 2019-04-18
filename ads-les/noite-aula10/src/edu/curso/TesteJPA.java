package edu.curso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteJPA {
	
	public static void createPlanetas(EntityManagerFactory emf) {
		Lua l1 = new Lua();
		l1.setId(1l);
		l1.setNome("Titan");
		Lua l2 = new Lua();
		l2.setId(2l);
		l2.setNome("Tutan");
		
		Planeta p1 = new Planeta();
		p1.setId(1l);
		p1.setNome("Kripton");
		p1.setDescoberto(new Date());
		p1.setDistanciaSol(4000000);
		p1.setQtdLuas(4);
		p1.setTamanho(67000);
		
		List<Lua> luas = new ArrayList<>();
		luas.add(l1);
		luas.add(l2);
		p1.setLuas(luas);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(l1);
		em.persist(l2);
		em.persist(p1);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void selecionarTodosPlanetas(EntityManagerFactory emf) { 
		EntityManager em = emf.createEntityManager();
		TypedQuery<Planeta> qry = em.createQuery("select p from Planeta p", Planeta.class);
		List<Planeta> lista = qry.getResultList();
		for (Planeta p : lista) { 
			System.out.println(p);
		}
		em.close();
	}
	
	public static void selecionarTodasLuas(EntityManagerFactory emf) { 
		EntityManager em = emf.createEntityManager();
		TypedQuery<Lua> qry = em.createQuery("select l from Lua l ", Lua.class);
		List<Lua> lista = qry.getResultList();
		for (Lua l : lista) { 
			System.out.println(l);
		}
		em.close();
	}

	public static void main(String[] args) {
		EntityManagerFactory 
		emf = Persistence.createEntityManagerFactory("PLANETAS");
		selecionarTodosPlanetas(emf);
		emf.close();

	}

}
