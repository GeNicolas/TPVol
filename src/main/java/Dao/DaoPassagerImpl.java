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

import Model.Passager;

@Repository
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
public class DaoPassagerImpl implements DaoPassager {
	
	@PersistenceContext
	private EntityManager em;

	public List<Passager> findAll() {
		List<Passager> passagers =null;
		Query query = em.createQuery("from Passager");
		passagers = query.getResultList();
		return passagers;
	}

	public Passager findByKey(Long key) {
		Passager passager=null;
		passager = em.find(Passager.class, key);
		return passager;
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void insert(Passager obj) {
			em.persist(obj);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public Passager update(Passager obj) {
		Passager passager = null;
			passager =em.merge(obj);
		return passager;
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void delete(Passager obj) {
		Passager passager = null;
			passager = em.find(Passager.class, obj.getId());
			em.remove(passager);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void deleteByKey(Long key) {
		Passager passager = null;
			passager = em.find(Passager.class, key);
			em.remove(passager);
	}
}
