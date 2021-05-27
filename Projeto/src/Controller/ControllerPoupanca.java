package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.ContaPoupanca;

public class ControllerPoupanca {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public void openConn() {
		this.emf = Persistence.createEntityManagerFactory("BANCO");
		this.em = emf.createEntityManager();
	}
	
	public void closeConn() {
		this.em.close();
		this.emf.close();
	}
	
	public void create (ContaPoupanca cp) {
		try {
			this.openConn();
			this.em.getTransaction().begin();
			this.em.persist(cp);
			this.em.getTransaction().commit();
			this.closeConn();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
}
