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
import Model.Ville;

@Repository
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
public class DaoVilleJpa implements DaoVille{
	
	@PersistenceContext
	private EntityManager em;

	public List<Ville> findAll() {
		Query query = em.createQuery("from Ville v");
		List<Ville> ville = query.getResultList();
		return ville;
	}

	public Ville findByKey(Long key) {
		Ville r = null;
		r = em.find(Ville.class, key);
		return r;
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void insert(Ville obj) {
			em.persist(obj);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public Ville update(Ville obj) {
		Ville ville = null;
			ville = em.merge(obj);
		return ville;
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void delete(Ville obj) {
			em.remove(em.merge(obj));
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void deleteByKey(Long key) {
			em.remove(em.find(Ville.class, key));
	}

	

}
