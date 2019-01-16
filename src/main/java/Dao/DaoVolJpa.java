package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Aeroport;
import Model.Vol;
import Util.Context;

public class DaoVolJpa implements DaoVol {

	public List<Vol> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Aeroport a");
		List<Vol> vol = null;
		vol = query.getResultList();
		em.close();
		return vol;
	}
	
	public Vol findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Vol r = null;
		r = em.find(Vol.class, key);
		em.close();
		return r;
	}

	public void insert(Vol obj) {
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

	public Vol update(Vol obj) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Vol vol = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			vol = em.merge(obj);
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //annuler une transaction
			}
		em.close();
		return vol;
	}

	public void delete(Vol obj) {
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

	public void deleteByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Vol.class, key));
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

	public List<Vol> findAllWithReservation() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Vol.findAllWithCompagnie");
		List<Vol> vols = query.getResultList();
		em.close();
		return vols;
	}

	public List<Vol> findAllWithAeroport() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Vol.findAllWithAeroport");
		List<Vol> vols = query.getResultList();
		em.close();
		return vols;
	}
	
	public List<Vol> findAllWithCompagnie() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Vol.findAllWithCompagnie");
		List<Vol> vols = query.getResultList();
		em.close();
		return vols;
	}

	

}
