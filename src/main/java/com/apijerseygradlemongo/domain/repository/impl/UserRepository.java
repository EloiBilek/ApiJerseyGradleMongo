/**
 * 
 */
package com.apijerseygradlemongo.domain.repository.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.mongodb.morphia.Datastore;

import com.apijerseygradlemongo.domain.entity.User;
import com.apijerseygradlemongo.domain.repository.AbstractRepository;


/**
 * @author eloibilek@gmail.com
 */
@RequestScoped
public class UserRepository extends AbstractRepository<User> {

	@Inject
	private Datastore mongoConnection;

	public UserRepository(Class<User> entityClass) {
		super(entityClass);
	}

	public UserRepository() {
		super(User.class);
	}

	@Override
	public Datastore getDatastore() {
		return mongoConnection;
	}

}
