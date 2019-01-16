package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Login;
import Util.Context;

public class DaoLoginImpl implements DaoLogin {

	public List<Login> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		List<Login> logins =null;
		Query query = em.createQuery("from Login");
		logins = query.getResultList();
		return logins;
	}

	public Login findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Login login=null;
		login = em.find(Login.class, key);
		
		return login;
	}

	public void insert(Login obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

	public Login update(Login obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Login login = null;
		
		try {
			tx.begin();
			login= em.merge(obj);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		return login;
	}

	public void delete(Login obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Login login = null;
		tx = em.getTransaction();
		try {
			tx.begin();
			login = em.find(Login.class, obj.getId());
			
			if (login.getClient()!=null) {
				login.getClient().setLogin(null);		
			}
			
			em.remove(login);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

	public void deleteByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Login login = null;
		tx = em.getTransaction();
		try {
			tx.begin();
			login = em.find(Login.class, key);
			
			if (login.getClient()!=null) {
				login.getClient().setLogin(null);		
			}
			
			em.remove(login);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

}
