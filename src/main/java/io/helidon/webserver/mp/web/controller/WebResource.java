package io.helidon.webserver.mp.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;
import org.slf4j.Logger;

@Path("/web")
@RequestScoped
public class WebResource {

	@Inject
	transient Logger logger;

	@SuppressWarnings("checkstyle:designforextension")
	@Path("/index")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Viewable getResource() {
		logger.info("######getResource()######");
		Map<String, String> model = new HashMap<>();
		model.put("hello", "Hello");
		model.put("world", "World");
		return new Viewable("/index", model);
	}

}
