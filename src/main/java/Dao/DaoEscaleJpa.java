package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.CompagnieAerienneVol;
import Model.Escale;
import Model.EscaleKey;
import Util.Context;

public class DaoEscaleJpa implements DaoEscale {

	public void insert(Escale obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	public Escale findByKey(EscaleKey key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Escale r = null;
		r = em.find(Escale.class, key);
		em.close();
		return r;
	}

	public Escale update(Escale obj) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Escale es = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			es = em.merge(obj);
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //annuler une transaction
			}
		em.close();
		return es;
	}

	public void delete(Escale obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			obj = em.merge(obj);
			em.remove(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		
	}

	public void deleteByKey(EscaleKey key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Escale.class, key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		
	}

	public List<Escale> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Escale es");
		List<Escale> es = null;
		es = query.getResultList();
		em.close();
		return es;
	}

	

}
