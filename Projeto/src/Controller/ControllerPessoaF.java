package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.PessoaFisica;

public class ControllerPessoaF {
	
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

	public void create(PessoaFisica pf) {
		try {
			//System.out.println("Executando");
			this.openConn();
			this.em.getTransaction().begin();
			this.em.persist(pf);
			this.em.flush();
			this.em.getTransaction().commit();
			this.closeConn();
			//System.out.println("Acabou");
		} catch (Exception e) {
			//System.out.println("FOI PARA O CATCH");
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
}
