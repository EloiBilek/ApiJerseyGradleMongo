/**
* 
*/
package com.apijerseygradlemongo.service;

import java.util.List;

import com.apijerseygradlemongo.domain.repository.AbstractRepository;

/**
 * @author eloibilek@gmail.com
 */
public abstract class AbstractService<T> implements IOperationsService<T> {

	public abstract AbstractRepository<T> getRepository();

	@Override
	public T findById(String id) {
		return getRepository().findById(id);
	}

	@Override
	public List<T> findAll() {
		return getRepository().findAll();
	}

	@Override
	public T create(T entity) {
		return getRepository().create(entity);
	}

	@Override
	public T update(T entity) {
		return getRepository().update(entity);
	}

	@Override
	public void delete(T entity) {
		getRepository().delete(entity);
	}

	@Override
	public void deleteById(String entityId) {
		getRepository().deleteById(entityId);
	}
}