package book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/book")
public class Book {

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/html")
	public String sayHelloHtml(){
		String res = "Hello from sayHelloXml";
		return res;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/json")
	public String sayHelloJson(){
		String res = "Hello from sayHelloJson";
		return res;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("{name}")
	public String sayHelloPathParam(@PathParam("name") String name){
		String res = "Hello from PathParam "+name+" Bye";
		return res;
	}
}