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

import Model.Aeroport;
import Model.Vol;

@Repository
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
public class DaoVolJpa implements DaoVol {

	@PersistenceContext
	private EntityManager em;
	
	
	public List<Vol> findAll() {
		Query query = em.createQuery("from Aeroport a");
		List<Vol> vol =  query.getResultList();
		return vol;
	}
	
	public Vol findByKey(Long key) {
		Vol r = null;
		r = em.find(Vol.class, key);
		return r;
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void insert(Vol obj) {
			em.persist(obj);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public Vol update(Vol obj) {
		Vol vol = null;
			vol = em.merge(obj);
		return vol;
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void delete(Vol obj) {
		em.remove(em.merge(obj));
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void deleteByKey(Long key) {
			em.remove(em.find(Vol.class, key));
	}

	public List<Vol> findAllWithReservation() {
		Query query = em.createNamedQuery("Vol.findAllWithCompagnie");
		List<Vol> vols = query.getResultList();
		return vols;
	}

	public List<Vol> findAllWithAeroport() {
		Query query = em.createNamedQuery("Vol.findAllWithAeroport");
		List<Vol> vols = query.getResultList();
		return vols;
	}
	
	public List<Vol> findAllWithCompagnie() {
		Query query = em.createNamedQuery("Vol.findAllWithCompagnie");
		List<Vol> vols = query.getResultList();
		return vols;
	}

	

}
