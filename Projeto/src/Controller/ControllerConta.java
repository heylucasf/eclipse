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
	
	public void update (ContaComum c) {
		try {
			this.openConn();
			this.em.getTransaction().begin();
			this.em.merge(c);
			this.em.getTransaction().commit();
			this.closeConn();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void delete (int id) {
		try {
			this.openConn();
			this.em.getTransaction().begin();
			ContaComum cc = this.em.find(ContaComum.class, id);
			this.em.remove(cc);
			this.em.getTransaction().commit();
			this.closeConn();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}
	}
	
	public ContaComum find(int id) {
		ContaComum aux = null;
		try {
			//System.out.println("Entrou no try");
			this.openConn();
			this.em.getTransaction().begin();
			aux = this.em.find(ContaComum.class, id);
			//System.out.println("AUX " + aux);
			this.em.getTransaction().commit();
			//System.out.println("Passou pelo commit");
			this.closeConn();
			
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			//System.out.println("FOI PARA O CATCH");
		}
		return aux;
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
