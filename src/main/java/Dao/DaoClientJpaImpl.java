package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Client;
import Model.Reservation;
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


		
	
	public Client findByKeyWithReservation (Integer key) {
		EntityManager em= Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("distinct c from Client c left join fetch c.reservation r where c.id=?1");
	
		query.setParameter(1, key);
		Client client = null;
		
		try{ 
			client= (Client) query.getSingleResult();
		}catch (Exception e) {
			
		}
		em.close();
		return client;
	}

	public Client findByKey(Long key){
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Client p = null;
		p = em.find(Client.class, key);
		em.close();
		return p;
	}


	public void deleteByKey(Long key) {
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
	


}


