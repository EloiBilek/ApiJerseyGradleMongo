/**
 * 
 */
package com.apijerseygradlemongo.domain.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

/**
 * @author eloibilek@gmail.com
 */
public abstract class AbstractRepository<T> implements IOperationsRepository<T> {

	private Class<T> entityClass;

	public AbstractRepository(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public T findById(String entityId) {
		Query<T> query = getDatastore().find(entityClass, "id", new ObjectId(entityId));
		return (T) query.get();
	}

	@Override
	public List<T> findAll() {
		List<T> list = new ArrayList<T>();
		list = getDatastore().find(entityClass).asList();
		return list;
	}

	@Override
	public T create(T entity) {
		getDatastore().save(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		getDatastore().save(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		getDatastore().delete(entity);
	}

	@Override
	public void deleteById(String entityId) {
		getDatastore().delete(entityClass, new ObjectId(entityId));
	}

	public abstract Datastore getDatastore();
}
