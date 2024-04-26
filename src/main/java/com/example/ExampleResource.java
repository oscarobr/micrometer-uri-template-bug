package com.example;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

	@GET
	@Path("/{message}")
	@Produces(MediaType.TEXT_PLAIN)
	public Uni<String> message(@PathParam("message") String message) {
		return Uni.createFrom().item(message);
	}
}
