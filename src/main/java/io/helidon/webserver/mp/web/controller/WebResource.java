package io.helidon.webserver.mp.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Template;
import org.glassfish.jersey.server.mvc.Viewable;
import org.slf4j.Logger;

import io.helidon.webserver.mp.entity.HelidonBean;

@Path("/web")
@RequestScoped
public class WebResource {

	@Inject
	transient Logger logger;

	@SuppressWarnings("checkstyle:designforextension")
	@Path("/index")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Viewable goIndex() {

		logger.info("######goIndex()######");
		Map<String, Object> model = new HashMap<>();
		model.put("hello", "Hello");
		model.put("world", "World");

		return new Viewable("/index", model);
	}

	@GET
	// @ErrorTemplate(name = "/error.ftl")
	@Template(name = "/helidon.ftl")
	@Path("/helidon")
	@Produces(MediaType.TEXT_HTML)
	public Map<String, Object> getAllHelidonSites() {

		logger.info("######getAllHelidonSites()######");
		List<HelidonBean> helidonSites = new ArrayList<>();

		helidonSites.add(new HelidonBean("Helidon Project", "https://helidon.io"));
		helidonSites.add(new HelidonBean("Helidon Docs", "https://helidon.io/docs"));
		helidonSites.add(new HelidonBean("Helidon API Docs",
				"https://helidon.io/docs/latest/apidocs/index.html?overview-summary.html"));
		helidonSites.add(new HelidonBean("Helidon Github", "https://github.com/oracle/helidon"));

		Map<String, Object> model = new HashMap<>();
		model.put("helidonSites", helidonSites);
		return model;
	}

}
