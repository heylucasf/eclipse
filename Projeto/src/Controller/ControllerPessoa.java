package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Pessoa;

public class ControllerPessoa {
	
	EntityManagerFactory emf;
	EntityManager em;

	public void openConn() {
		this.emf = Persistence.createEntityManagerFactory("BANCO");
		this.em = this.emf.createEntityManager();
	}

	public void closeConn() {
		this.em.close();
		this.emf.close();
	}

	public void create(Pessoa p) {
		try {
			this.openConn();
			this.em.getTransaction().begin();
			this.em.persist(p);
			this.em.flush();
			this.em.getTransaction().commit();
			this.closeConn();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
}
