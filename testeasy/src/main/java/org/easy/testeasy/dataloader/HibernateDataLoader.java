package org.easy.testeasy.dataloader;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Session;

/**
 * Data loader que utiliza o EntityManager para carregamento dos dados.
 * @author augusto
 *
 */
public abstract class HibernateDataLoader implements DataLoader {

	/** Para acesso à conexão com a base de dados. */
	private EntityManager entityManager;
	
	protected Session getSession() {
		return  entityManager != null ? (Session) entityManager.getDelegate() : null;
	}
	
	// getters and setters

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Inject
	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
