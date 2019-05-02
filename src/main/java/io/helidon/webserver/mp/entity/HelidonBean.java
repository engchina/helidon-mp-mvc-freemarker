package io.helidon.webserver.mp.entity;

public class HelidonBean {

	private String name;
	private String site;

	public HelidonBean(String name, String site) {
		super();
		this.name = name;
		this.site = site;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}
