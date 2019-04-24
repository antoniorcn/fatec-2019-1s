package edu.curso.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	private static ConnectionFactory instancia;
	private EntityManagerFactory emf;
	
	private ConnectionFactory() {
		emf = Persistence.createEntityManagerFactory("ALUGUELCARROS");
	}
	
	public EntityManager getEntityManager() { 
		return emf.createEntityManager();
	}
	
	public static ConnectionFactory getInstance() { 
		if (instancia == null) { 
			instancia = new ConnectionFactory();
		}
		return instancia;
	}
	

}
