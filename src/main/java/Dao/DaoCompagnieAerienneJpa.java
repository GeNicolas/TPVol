package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Aeroport;
import Model.CompagnieAerienne;
import Model.Ville;
import Model.Vol;
import Util.Context;

public class DaoCompagnieAerienneJpa implements DaoCompagnieAerienne {

	public void insert(CompagnieAerienne obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
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

	public CompagnieAerienne findByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		CompagnieAerienne r = null;
		r = em.find(CompagnieAerienne.class, key);
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

	public void delete(CompagnieAerienne obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			obj = em.merge(obj);
			for (Vol v : obj.getVols()) {
				em.remove(v);
			}
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
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(CompagnieAerienne.class, key));
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

	public List<CompagnieAerienne> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from CompagnieAerienne ca");
		List<CompagnieAerienne> compagnieAerienne = null;
		compagnieAerienne = query.getResultList();
		em.close();
		return compagnieAerienne;
	}

	public CompagnieAerienne update(CompagnieAerienne obj) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		CompagnieAerienne compagnieAerienne = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			compagnieAerienne = em.merge(obj);
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //annuler une transaction
			}
		em.close();
		return compagnieAerienne;
	}


}
