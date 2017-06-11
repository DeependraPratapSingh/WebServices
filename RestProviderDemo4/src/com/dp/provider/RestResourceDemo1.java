package com.dp.provider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("demo1")
@XmlRootElement
public class RestResourceDemo1 {
//	http://localhost:8080/RestProviderDemo4/rest/demo1/5/5
	@GET
	@Path("{a}/{b}")
	public int add(@PathParam("a") int a,@PathParam("b") int b){
		return a+b;
	}
//	http://localhost:8080/RestProviderDemo4/rest/demo1/5,5,5
	@GET
	@Path("{a},{b},{c}")
	public int add    (@PathParam("a") int a, @PathParam("b") int b, @PathParam("c") int c){
		return a+b+c;
	}
//	http://localhost:8080/RestProviderDemo4/rest/demo1/hello
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("hello")
	public String add(){
		return "hello";
	}
}