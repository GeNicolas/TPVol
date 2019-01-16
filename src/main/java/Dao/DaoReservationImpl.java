package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Reservation;
import Util.Context;

public class DaoReservationImpl implements DaoReservation{

	public List<Reservation> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		List<Reservation> reservations =null;
		Query query = em.createQuery("from Reservation");
		reservations = query.getResultList();
		return reservations;
	}

	public Reservation findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Reservation reservation=null;
		reservation = em.find(Reservation.class, key);
		
		return reservation;
	}

	public void insert(Reservation obj) {
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

	public Reservation update(Reservation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Reservation reservation = null;
		
		try {
			tx.begin();
			reservation =em.merge(obj);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		return reservation;
	}

	public void delete(Reservation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

	public void deleteByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.remove(em.find(Reservation.class, key));
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

}
