package com.dp.univrtsity;
/*
 * Sending data(name, age) from Consumer by using post method to RestProvider and RestProvider will proceed data and then sending back 
 * response as confermation 
 */
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/university")
public class UniversityRESTWS 
{
	@POST
	@Path("/add")
//	@Produces(MediaType.TEXT_PLAIN)
	public String getStudentInfo(@FormParam("name") String name, @FormParam("age") int age)
	{
		return "WebServices has added the student's information with name :"+name+ " and Age :"+age;
	}
	
}