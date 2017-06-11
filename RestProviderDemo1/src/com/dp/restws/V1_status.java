package com.dp.restws;

import com.dp.restws.Track;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/v1/status")
public class V1_status 
{
	private static final String api_version = "00.01.00";
	
	@GET
	@Produces(MediaType.TEXT_HTML)
//	@Produces(MediaType.APPLICATION_XML)
	public String returnTitle()
	{
		return "<h2>Java Web Services</h2>";
	}

	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
//	@Produces(MediaType.APPLICATION_JSON)
	public String returnVersion()
	{
		return "<h3>Version :: </h3>"+api_version;
	}
	
	@Path("/pp")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackINJson()
	{
		Track track = new Track();
		track.setTitle("Enter Sandam");
		track.setSinger("Matallica");
		track.setName("Deependra");
		track.setMidname("pratap");
		track.setLastname("Singh");
		
		return track;
	}
}