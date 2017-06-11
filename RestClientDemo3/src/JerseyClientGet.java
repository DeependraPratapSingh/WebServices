import javax.management.RuntimeErrorException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class JerseyClientGet 
{
	public static void main(String[] args) 
	{
		try 
		{
			Client client=Client.create();
			WebResource webResource=client.resource("http://localhost:8080/RestProviderDemo3/rest/v1/status/pp");
			String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";
			
			ClientResponse response=webResource.type("application/json").post(ClientResponse.class,input);
			
			if (response.getStatus() != 201) 
			{
				throw new RuntimeErrorException(null, "Failed : HTTP error code : "+response.getStatus());
			}
			String output = response.getEntity(String.class);
			System.out.println("Output from server ... \n");
			System.out.println(output);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
