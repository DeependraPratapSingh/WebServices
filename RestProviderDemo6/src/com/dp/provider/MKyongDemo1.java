package com.dp.provider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/mkdemo2")
@XmlRootElement
@Produces(MediaType.APPLICATION_JSON)
public class MKyongDemo1 {
	
	@GET
	@Path("/{message}")
//	@Produces(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response getMessage(@PathParam("message") String msg){
		String output = "Jersey Says : "+msg;
		return Response.status(200).entity(output).build();
	}
}