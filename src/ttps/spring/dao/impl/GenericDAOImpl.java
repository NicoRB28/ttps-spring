package ttps.spring.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import ttps.spring.dao.GenericDAO;

@Transactional
public class GenericDAOImpl<T> implements GenericDAO<T> {
	
	protected Class<T> persistentClass;
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}
	
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	public GenericDAOImpl(Class<T> c) {
		this.persistentClass = c;
	}
	
	@Override
	public T update(T entity) {
		T updateEntity = this.getEntityManager().merge(entity);
		return updateEntity;
	}

	@Override
	public void delete(T entity) {
			T dbEntity = this.getEntityManager().merge(entity);
			this.getEntityManager().remove(dbEntity);	
	}

	@Override
	public  void delete(Serializable id) {
		T entity = this.getEntityManager().find(this.persistentClass, id);
		this.getEntityManager().remove(entity);
	}

	@Override
	public T findById(Serializable id) {	
		T entity = this.getEntityManager().find(this.persistentClass, id);
		return entity;
	}

	@Override
	public List<T> findAll() {
		
		return  this.getEntityManager().createQuery("FROM "+ this.persistentClass.getName())
									   .getResultList();
		
	}

	@Override
	public T save(T entity) {
		this.getEntityManager().persist(entity);
		return entity;
	}

}
