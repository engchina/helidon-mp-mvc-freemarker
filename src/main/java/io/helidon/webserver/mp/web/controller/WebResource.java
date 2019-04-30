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

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import org.glassfish.jersey.server.mvc.Viewable;
import org.slf4j.Logger;

import io.helidon.webserver.mp.entity.BookBean;
import io.helidon.webserver.mp.entity.Fruit;

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

		BookBean bookBean = new BookBean();
		bookBean.setNumber(101);
		bookBean.setName("Helidon Quickstart");
		model.put("bookBean", bookBean);

		return new Viewable("/index", model);
	}

	@GET
	@ErrorTemplate(name = "/error.ftl")
	@Template(name = "/all.ftl")
	@Path("/all")
	@Produces(MediaType.TEXT_HTML)
	public Map<String, Object> getAllFruit() {
		logger.info("######getAllFruit()######");
		List<Fruit> fruits = new ArrayList<>();
		fruits.add(new Fruit("banana", "yellow"));
		fruits.add(new Fruit("apple", "red"));
		fruits.add(new Fruit("kiwi", "green"));

		Map<String, Object> model = new HashMap<>();
		model.put("items", fruits);
		return model;
	}

}
