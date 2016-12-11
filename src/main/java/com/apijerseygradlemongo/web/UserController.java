package com.apijerseygradlemongo.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.apijerseygradlemongo.service.IUserService;

/**
 * @author eloi eloibilek@gmail.com
 */

@Path("users")
@RequestScoped
public class UserController {

	@Inject
	private IUserService userService;

	private static Logger LOGGER = Logger.getLogger(UserController.class);

	public UserController() {
		super();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/test")
	public Response testCall() {
		LOGGER.info(":::::::::: API UP ::::::::::");
		if (userService != null)
			LOGGER.info(":::::::::: CDI WORK ::::::::::");
		return Response.status(200).entity(">>>>>> Jersey API ON <<<<<<<").build();
	}

}
