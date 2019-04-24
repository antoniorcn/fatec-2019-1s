package edu.curso.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class ConnectionBuilderORM {
	private static ConnectionBuilderORM instancia;
	private EntityManagerFactory emf;
	private ConnectionBuilderORM() { 
		emf = Persistence.createEntityManagerFactory("JOGOS");
	}
	public static ConnectionBuilderORM getInstance() {
		if (instancia == null) { 
			instancia = new ConnectionBuilderORM();
		}
		return instancia;
	}
	public EntityManager getConnection() {
		return emf.createEntityManager();
	}
}
