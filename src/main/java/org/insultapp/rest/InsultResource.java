package org.insultapp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class InsultResource {

	@GET
	@Produces(value = MediaType.TEXT_PLAIN)
	public String insult() {
		return "Hello, code monkey";
	}
}
