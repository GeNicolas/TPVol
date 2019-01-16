package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Client;
import Util.Context;


public class DaoClientJpaImpl implements DaoClient{
	
	
	@SuppressWarnings("unchecked") 
	public List<Client> findAll() {
		List<Client> personnes = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select c from Client c"); //"from Personne p" fonctionne aussi
		personnes=query.getResultList();
		em.close();
		return personnes;
	}

	public Client findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Client p = null;
		p = em.find(Client.class, key);
		em.close();
		return p;
	}

	public void insert(Client obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();

	}

	public Client update(Client obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Client Client=null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Client=em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		return Client;
	}

	public void delete(Client objet) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(objet));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

	public void deleteByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Client.class, key));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}
	
	public Rerservation findByKeyWithReservation (Integer key) {
		EntityManager em= Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select c from Client c left join fetch a.id_article art left join fetch art.id where a.id=key?");
	
		query.setParameter("key", key);
		List<Rerservation> reservation = null;
		
		try{ 
			reservation= (List<Reservation>) query.getResultList();
		}catch (Exception e) {
			
		}
		em.close();
		return reservation;
	}
}

