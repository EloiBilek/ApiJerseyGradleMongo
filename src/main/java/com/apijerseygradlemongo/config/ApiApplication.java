package com.apijerseygradlemongo.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.apijerseygradlemongo.web.UserController;

/**
 * @author eloi eloibilek@gmail.com
 */

@ApplicationPath("v1")
public class ApiApplication extends Application {

	private final Set<Class<?>> classes;

	public ApiApplication() {
		HashSet<Class<?>> c = new HashSet<Class<?>>();
		c.add(UserController.class);
		classes = Collections.unmodifiableSet(c);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
}
