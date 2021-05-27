package Controller;

import java.util.ArrayList;

import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.ContaComum;

public class ControllerConta {
	
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
	
	public void create(ContaComum c) {
		try {
			this.openConn();
			this.em.getTransaction().begin();
			this.em.persist(c);
			this.em.getTransaction().commit();
			this.closeConn();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public ContaComum find(int nc) {
		String hql = "SELECT o FROM ContaComum o WHERE o.nro_conta = '" + nc + "'";
		this.openConn();
		Query q = this.em.createQuery(hql);
		ContaComum result = (ContaComum) q.getResultList().get(0);
		this.closeConn();
		return result;
	}
	
	public ArrayList<ContaComum> list(){
		String hql = "SELECT o FROM ContaComum o";
		this.openConn();
		
		Query query = (Query) this.em.createQuery(hql);
		ArrayList<ContaComum> result = (ArrayList<ContaComum>) query.getResultList();
		
		this.closeConn();
		return result;
	}

}
