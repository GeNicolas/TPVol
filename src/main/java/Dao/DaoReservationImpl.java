package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import Model.Reservation;

@Repository
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
public class DaoReservationImpl implements DaoReservation{

	@PersistenceContext
	private EntityManager em;
	
	public List<Reservation> findAll() {
		List<Reservation> reservations =null;
		Query query = em.createQuery("from Reservation");
		reservations = query.getResultList();
		return reservations;
	}

	public Reservation findByKey(Integer key) {
		Reservation reservation=null;
		reservation = em.find(Reservation.class, key);
		return reservation;
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void insert(Reservation obj) {
			em.persist(obj);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public Reservation update(Reservation obj) {
		Reservation reservation = null;
			reservation =em.merge(obj);
		return reservation;
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void delete(Reservation obj) {
			em.remove(em.merge(obj));
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void deleteByKey(Integer key) {
			em.remove(em.find(Reservation.class, key));
	}
}
