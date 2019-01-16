package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Aeroport;
import Model.CompagnieAerienneKey;
import Model.CompagnieAerienneVol;
import Model.Ville;
import Util.Context;

public class DaoCompagnieAerienneVolJpa implements DaoCompagnieAerienneVol{

	public void insert(CompagnieAerienneVol obj) {
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

	public CompagnieAerienneVol findByKey(CompagnieAerienneKey key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		CompagnieAerienneVol r = null;
		r = em.find(CompagnieAerienneVol.class, key);
		em.close();
		return r;
	}

	public CompagnieAerienneVol update(CompagnieAerienneVol obj) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		CompagnieAerienneVol cav = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			cav = em.merge(obj);
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //annuler une transaction
			}
		em.close();
		return cav;
	}

	public void delete(CompagnieAerienneVol obj) {
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

	public void deleteByKey(CompagnieAerienneKey key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(CompagnieAerienneVol.class, key));
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

	public List<CompagnieAerienneVol> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from CompagnieAerienneVol cav");
		List<CompagnieAerienneVol> cav = null;
		cav = query.getResultList();
		em.close();
		return cav;
	}

	

}
