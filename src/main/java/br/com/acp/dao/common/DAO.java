package br.com.acp.dao.common;

import br.com.acp.exception.AcessoDBError;


import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@SuppressWarnings("unchecked")
public abstract class DAO<T> implements DAOLocal<T> {

	@PersistenceContext(unitName = "acpPU")
	private EntityManager em;

	@Transactional
	public void salvar(T entity) throws AcessoDBError {
		em.persist(entity);
	}

	@Transactional
	public void atualizar(T entity) throws AcessoDBError {
		em.merge(entity);
	}

	@Transactional
	public void remover(Serializable id, Class<T> clazz) throws AcessoDBError {
		em.remove(getUm(id, clazz));
	}

	public T getUm(Serializable id, Class<T> clazz) throws AcessoDBError {
		T retorno = (T) em.find(clazz, id);
		return retorno;
	}

	public List<T> listar(Class<T> clazz) throws AcessoDBError {
		return em.createQuery("Select t from " + clazz.getSimpleName() + " t").getResultList();
	}

	public EntityManager getEm() {
		return em;
	}
}
