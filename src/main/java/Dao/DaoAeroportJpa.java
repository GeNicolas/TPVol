package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Aeroport;
import Model.Ville;
import Util.Context;

public class DaoAeroportJpa implements DaoAeroport{

	public void insert(Aeroport obj) {
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

	public Aeroport findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Aeroport r = null;
		r = em.find(Aeroport.class, key);
		em.close();
		return r;
	}

	public Aeroport update(Aeroport obj) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Aeroport aeroport = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			aeroport = em.merge(obj);
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //annuler une transaction
			}
		em.close();
		return aeroport;
	}

	public void delete(Aeroport obj) {
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
			em.remove(em.find(Aeroport.class, key));
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

	public List<Aeroport> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Aeroport a");
		List<Aeroport> aeroports = null;
		aeroports = query.getResultList();
		em.close();
		return aeroports;
	}

	public List<Aeroport> findAllWithVol() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Aeroport.findAllWithVol");
		List<Aeroport> aeroport = query.getResultList();
		em.close();
		return aeroport;
	}
	
	public List<Aeroport> findAllWithVille() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Aeroport.findAllWithVille");
		List<Aeroport> aeroport = query.getResultList();
		em.close();
		return aeroport;
	}


	

}
