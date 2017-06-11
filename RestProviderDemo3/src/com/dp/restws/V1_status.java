package com.dp.restws;


import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/v1/status")
public class V1_status 
{
	@Path("/pp")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTrackINJson(Track track)
	{
		String result = "Track saved :"+track;
		
		return Response.status(201).entity(result).build();
		
/*		Track track = new Track();
		track.setTitle("Enter Sandam");
		track.setSinger("Matallica");
		track.setName("Deependra");
		track.setMidname("pratap");
		track.setLastname("Singh");
		
		return track;*/
	}
}