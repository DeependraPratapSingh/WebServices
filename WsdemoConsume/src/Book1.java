import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class Book1 
{
	//1- Create a Client
	Client client = Client.create();
	
	//2- Set the target for client
	WebResource resourse = client.resource("http://localhost:8080/WsdemoProduces/book/deependra");
	
	//3- Get Response from WS
	ClientResponse response = resourse.type(MediaType.TEXT_HTML).get(ClientResponse.class);
	
	
//	ClientResponse response=webResource.type("application/json").post(ClientResponse.class,input);
}