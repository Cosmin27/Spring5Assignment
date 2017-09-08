package com.cgm.assignment5spring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@EnableTransactionManagement
public abstract class AbstractDAO<E> {
	
	@PersistenceContext(name="assignment5spring")
	private EntityManager entityManager;
	
	private final Class<E> entityClass;
	
	protected AbstractDAO(final Class<E> entityClass) {
		this.entityClass = entityClass;
	}
	
	@Transactional
	public EntityManager em() {
		return entityManager;
	}
	
	@Transactional
	public E findById(final Long entityId) {
		return entityManager.find(entityClass, entityId);
	}
	
	@Transactional
	public void save(final E entityToBeSaved) {
		entityManager.persist(entityToBeSaved);
	}
	
	@Transactional
	public void update(final E entityToBeUpdated) {
		entityManager.merge(entityToBeUpdated);
	}
	
	@Transactional
	public void remove(final E entityToBeRemoved) {
		entityManager.remove(entityToBeRemoved);
	}
	
	@Transactional
	public void delete(final Long id) {
		entityManager.remove(findById(id));
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> findAll() {
		return (List<E>) entityManager.createQuery(
				new StringBuilder().append("SELECT entity FROM ")
						.append(entityClass.getCanonicalName())
						.append(" entity ").toString()).getResultList();
	}
}
