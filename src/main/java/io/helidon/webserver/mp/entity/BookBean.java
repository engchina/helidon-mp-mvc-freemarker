package io.helidon.webserver.mp.entity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class BookBean {

	private Integer number;
	private String name;

	public void toConsole() {
		System.out.println("number=" + this.number + "/ name=" + this.name);
	}

	public String next() {
		return null;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
