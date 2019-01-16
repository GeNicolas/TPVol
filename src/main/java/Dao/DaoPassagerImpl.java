package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Passager;
import Util.Context;

public class DaoPassagerImpl implements DaoPassager {

	public List<Passager> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		List<Passager> passagers =null;
		Query query = em.createQuery("from Passager");
		passagers = query.getResultList();
		return passagers;
	}

	public Passager findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Passager passager=null;
		passager = em.find(Passager.class, key);
		
		return passager;
	}

	public void insert(Passager obj) {
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

	public Passager update(Passager obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Passager passager = null;
		
		try {
			tx.begin();
			passager =em.merge(obj);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		return passager;
	}

	public void delete(Passager obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Passager passager = null;
		tx = em.getTransaction();
		try {
			tx.begin();
			passager = em.find(Passager.class, obj.getId());
			
			if (passager.getReservations()!=null) {
				for (int i=0; i<passager.getReservations().size(); i++ ) {
					passager.getReservations().get(i).setClient(null);
				}
					
			}
			
			em.remove(passager);
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
		Passager passager = null;
		tx = em.getTransaction();
		try {
			tx.begin();
			passager = em.find(Passager.class, key);
			
			if (passager.getReservations()!=null) {
				for (int i=0; i<passager.getReservations().size(); i++ ) {
					passager.getReservations().get(i).setClient(null);
				}
					
			}
			
			em.remove(passager);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

}
