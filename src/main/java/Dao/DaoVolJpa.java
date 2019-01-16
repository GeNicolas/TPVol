package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Model.Aeroport;
import Model.Vol;
import Util.Context;

public class DaoVolJpa implements DaoVol {

	public List<Vol> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Vol findByKey(Long key) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(Vol obj) {
		// TODO Auto-generated method stub
		
	}

	public Vol update(Vol obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Vol obj) {
		// TODO Auto-generated method stub
		
	}

	public void deleteByKey(Long key) {
		// TODO Auto-generated method stub
		
	}

	public List<Vol> findAllWithReservation() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Vol.findAllWithCompagnie");
		List<Vol> vols = query.getResultList();
		em.close();
		return vols;
	}

	public List<Vol> findAllWithAeroport() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Vol.findAllWithAeroport");
		List<Vol> vols = query.getResultList();
		em.close();
		return vols;
	}
	
	public List<Vol> findAllWithCompagnie() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Vol.findAllWithCompagnie");
		List<Vol> vols = query.getResultList();
		em.close();
		return vols;
	}

	

}
