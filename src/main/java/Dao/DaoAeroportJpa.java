package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import Model.Aeroport;

@Repository
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
public class DaoAeroportJpa implements DaoAeroport{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void insert(Aeroport obj) {
			em.persist(obj);
	}

	public Aeroport findByKey(Long key) {
		Aeroport r = null;
		r = em.find(Aeroport.class, key);
		return r;
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public Aeroport update(Aeroport obj) {
		Aeroport aeroport = null;
			aeroport = em.merge(obj);
		return aeroport;
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void delete(Aeroport obj) {
		em.remove(em.merge(obj));
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void deleteByKey(Long key) {
			em.remove(em.find(Aeroport.class, key));
	}

	public List<Aeroport> findAll() {
		Query query = em.createQuery("from Aeroport a");
		List<Aeroport> aeroports =  query.getResultList();
		return aeroports;
	}

	public List<Aeroport> findAllWithVol() {
		Query query = em.createNamedQuery("Aeroport.findAllWithVol");
		List<Aeroport> aeroport = query.getResultList();
		return aeroport;
	}
	
	public List<Aeroport> findAllWithVille() {
		Query query = em.createNamedQuery("Aeroport.findAllWithVille");
		List<Aeroport> aeroport = query.getResultList();
		return aeroport;
	}


	

}
