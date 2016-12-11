/**
 * 
 */
package com.apijerseygradlemongo.service.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.apijerseygradlemongo.domain.entity.User;
import com.apijerseygradlemongo.domain.repository.AbstractRepository;
import com.apijerseygradlemongo.domain.repository.IUserRepository;
import com.apijerseygradlemongo.domain.repository.impl.UserRepository;
import com.apijerseygradlemongo.service.AbstractService;

/**
 * @author eloibilek@gmail.com
 *
 */
@RequestScoped
public class UserService extends AbstractService<User> {

	private IUserRepository userRepository;

	@Inject
	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public AbstractRepository<User> getRepository() {
		return (UserRepository) userRepository;
	}

}
